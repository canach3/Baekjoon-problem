import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < T; i++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			
			int K = Integer.parseInt(br.readLine().trim());
			for (int j = 0; j < K; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				
				switch (command) {
					case 'I':
						int key = Integer.parseInt(st.nextToken());
						treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
						break;
					case 'D':
						int command2 = Integer.parseInt(st.nextToken());
						
						if (treeMap.isEmpty()) continue;
						
						if (command2 == 1) {
							Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();
							int lastKey = lastEntry.getKey();
							int cnt = lastEntry.getValue();
							
							if (cnt == 1) {
								treeMap.pollLastEntry();
							} else {
								treeMap.put(lastKey, cnt - 1);
							}
						} else {
							Map.Entry<Integer, Integer> firstEntry = treeMap.firstEntry();
							int firstKey = firstEntry.getKey();
							int cnt = firstEntry.getValue();
							
							if (cnt == 1) {
								treeMap.pollFirstEntry();
							} else {
								treeMap.put(firstKey, cnt - 1);
							}
						}
						break;
				}
			}
			
			if (treeMap.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}