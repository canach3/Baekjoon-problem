import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] treeCnt = new int[10000];
		List<String> treeList = new ArrayList<>();
		Map<String, Integer> hashMap = new HashMap<>();
		
		int size = 0;
		int totalCnt = 0;
		
		String tree;
		while((tree = br.readLine()) != null) {
			Integer idx = hashMap.get(tree);
			
			if (idx == null) {
				hashMap.put(tree, size++);
				treeList.add(tree);
				treeCnt[size - 1]++;
				totalCnt++;
			} else {
				treeCnt[idx]++;
				totalCnt++;
			}
		}
		
		Collections.sort(treeList);
		
		for (int i = 0; i < treeList.size(); i++) {
			sb.append(treeList.get(i)).append(" ");
			
			int idx = hashMap.get(treeList.get(i));
			
			sb.append(String.format("%.4f", (double) treeCnt[idx] / totalCnt * 100.0)).append("\n");
		}
		
		System.out.print(sb);
	}
}