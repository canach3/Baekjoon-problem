import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] treeCnt = new int[10000];
		Map<String, Integer> treeMap = new TreeMap<>();
		
		int size = 0;
		int totalCnt = 0;
		
		String treeName;
		while((treeName = br.readLine()) != null) {
			Integer idx = treeMap.get(treeName);
			
			if (idx == null) {
				treeMap.put(treeName, size++);
				
				treeCnt[size - 1]++;
				totalCnt++;
			} else {
				treeCnt[idx]++;
				totalCnt++;
			}
		}
		
		
		for (String tree : treeMap.keySet()) {
			sb.append(tree).append(" ");
			
			int idx = treeMap.get(tree);
			double percentage = (double) treeCnt[idx] / totalCnt * 100.0;
			
			sb.append(String.format("%.4f", percentage)).append("\n");
		}
			
		System.out.print(sb);
	}
}