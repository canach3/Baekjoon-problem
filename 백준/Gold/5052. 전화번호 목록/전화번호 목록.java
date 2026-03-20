import java.io.*;
import java.util.*;

public class Main {
	static Map<String, Integer> map;
	static List<String>[] numList;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine().trim());

			map = new HashMap<>();
			numList = new List[11];
			for (int i = 0; i <= 10; i++) {
				numList[i] = new ArrayList<>();
			}
			
			boolean isSame = false;
			
			for (int i = 0; i < N; i++) {
				String num = br.readLine().trim();
				
				numList[num.length()].add(num);
			}
			
			for (int i = 1; i <= 10; i++) {
				List<String> list = numList[i];
				
				for (int j = 0; j < list.size(); j++) {
					String num = list.get(j);
					
					for (int k = 1; k <= num.length(); k++) {
						String tmp = num.substring(0, k);
						
						// 발견하는 즉시 빠져나오기
						if(map.containsKey(tmp)) {
							sb.append("NO").append("\n");
							isSame = true;
							break;
						}
					}
					
					if (isSame) break;
					
					// 마지막엔 자기 자신값 map 에 저장
					map.put(num,  1);
				}
				
				if (isSame) break;
			}
			
			if (isSame) continue;
			
			sb.append("YES").append("\n");
		}
	
		System.out.print(sb);
	}
}