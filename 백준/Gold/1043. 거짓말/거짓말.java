import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. Union-Find 부모 배열 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 2. 진실을 아는 사람 정보 입력
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        
        // 진실을 아는 사람이 아예 없다면, 모든 파티에서 과장 가능! (빠른 종료)
        if (truthCount == 0) {
            System.out.println(m);
            return;
        }

        int[] truthPeople = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        // 진실을 아는 사람들을 하나의 집합으로 묶기
        int truthRoot = truthPeople[0];
        for (int i = 1; i < truthCount; i++) {
            union(truthRoot, truthPeople[i]);
        }

        // 3. 파티 정보 입력 및 같은 파티 참석자를 하나의 집합으로 묶기
        List<Integer>[] parties = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            int firstPerson = Integer.parseInt(st.nextToken());
            parties[i].add(firstPerson);

            for (int j = 1; j < partySize; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person);
                union(firstPerson, person); // 파티에 온 사람들을 전부 연결
            }
        }

        // 4. 과장할 수 있는 파티 개수 계산
        int result = 0;
        truthRoot = find(truthPeople[0]); // 진실을 아는 그룹의 최종 대표(Root)

        for (int i = 0; i < m; i++) {
            int partyFirstPerson = parties[i].get(0);
            
            // 파티의 참석자가 진실을 아는 그룹과 연결되어 있지 않다면 과장 가능
            if (find(partyFirstPerson) != truthRoot) {
                result++;
            }
        }

        System.out.println(result);
    }

    // 부모(Root) 노드를 찾는 함수 (경로 압축 최적화 적용)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 두 노드를 하나의 집합으로 합치는 함수
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}