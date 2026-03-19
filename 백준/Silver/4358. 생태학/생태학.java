import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> treeMap = new TreeMap<>();
		int totalCnt = 0;
		
		String treeName;
		while((treeName = br.readLine()) != null) {
			Integer cnt = treeMap.get(treeName);
			
			if (cnt == null) {
				treeMap.put(treeName, 1);
				totalCnt++;
			} else {
				treeMap.replace(treeName, cnt + 1);
				totalCnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (String tree : treeMap.keySet()) {
			sb.append(tree).append(" ");
			
			double percentage = (double) treeMap.get(tree) / totalCnt * 100.0;
			
			sb.append(String.format("%.4f", percentage)).append("\n");
		}
			
		System.out.print(sb);
	}
}