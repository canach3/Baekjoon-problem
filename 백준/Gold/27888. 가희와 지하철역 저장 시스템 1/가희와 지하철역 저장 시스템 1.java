import java.io.*;
import java.util.*;

public class Main {
    static int cnt; // 현재까지 나온 특징 수
    static Map<String, Integer> f_keyMap; // 각 특징의 키
    static Map<Integer, List<String>> fix_sMap; // 해당 특징조합(인덱스)을 가진 역들
    static Map<String, Integer> s_fixMap; // 해당 역이 가지고있는 특징조합

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        f_keyMap = new HashMap<>();
        fix_sMap = new HashMap<>();
        s_fixMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            String station = br.readLine();
        }

        int M = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            List<String> features = new ArrayList<>();

            switch (command) {
                case 'U':
                    String station = st.nextToken();

                    if (st.hasMoreTokens()) {
                        String featureGroup = st.nextToken();
                        // 콤마(,)를 기준으로 정확하게 쪼개서 배열로 만듭니다.
                        String[] splitFeatures = featureGroup.split(",");

                        for (String feature : splitFeatures) {
                            features.add(feature);
                        }
                    }

                    U(station, features);
                    break;
                case 'G':
                    if (st.hasMoreTokens()) {
                        String featureGroup = st.nextToken();
                        // 콤마(,)를 기준으로 정확하게 쪼갭니다.
                        String[] splitFeatures = featureGroup.split(",");

                        for (String feature : splitFeatures) {
                            features.add(feature);
                        }
                    }

                    sb.append(G(features)).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }

    static void U(String station, List<String> features) {
        // station : 역 이름
        // features : 특징들

        // 1. 해당 역이 가지고있는 특징조합 찾기, 삭제
        Integer fixKey = s_fixMap.remove(station);

        // 2. 해당 특징조합에서 역 삭제하기(swap으로 삭제하기)
        if (fixKey != null) {
            List<String> stationList = fix_sMap.get(fixKey);

            int idx = stationList.indexOf(station);
            stationList.set(idx, stationList.get(stationList.size() - 1));
            stationList.remove(stationList.size() - 1);
        }

        // 3. 특징이 이미 존재하는 특징인 지 확인
        for (String feature : features) {
            Integer fKey = f_keyMap.get(feature);

            // 3-2. 없다면 해당 특징에 키값 부여
            if (fKey == null) {
                f_keyMap.put(feature, (int) Math.pow(10, cnt++));
            }
        }

        // 4. 해당 특징들을 다 더해서 하나의 특징조합으로 만들기
        int fMixKey = 0;
        for (String feature : features) {
            fMixKey += f_keyMap.get(feature);
        }

        // 5. 해당 특징조합에 역 추가하기
        if (fix_sMap.get(fMixKey) == null) fix_sMap.put(fMixKey, new ArrayList<>());
        fix_sMap.get(fMixKey).add(station);

        // 6. 해당 역에 특징조합 매핑하기
        s_fixMap.put(station, fMixKey);

        // TODO : station 의 특징을 features로 업데이트

        // 요청 수 : 100,000
    }

    static int G(List<String> features) {
        // features : 특징들

        // 1. 해당특징들의 키를 더해 하나의 조합 키로 만들기
        int fMixKey = 0;
        for (String feature : features) {
            Integer fKey = f_keyMap.get(feature);

            if (fKey == null) return 0;

            fMixKey += f_keyMap.get(feature);
        }

        // 2. (해당특징들) 을 포함하는 키의 list size 다 더하기
        int cnt = 0;

        int fMixKeyTo2 = Integer.parseInt(String.valueOf(fMixKey), 2);
        for (int key : fix_sMap.keySet()) {
            int keyTo2 = Integer.parseInt(String.valueOf(key), 2);
            if ((fMixKeyTo2 & keyTo2) == fMixKeyTo2) {
                cnt += fix_sMap.get(key).size();
            }
        }

                // and 연산이 곧 키 값이라면 ㄱㄱ

        // TODO : 해당 특징들을 모두 가진 역 개수 찾기

        // 요청 수 : 100,000

        // return : 해당하는 역 개수 반환
        return cnt;
    }
}