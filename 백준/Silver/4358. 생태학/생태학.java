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
			} else {
				treeMap.replace(treeName, cnt + 1);
			}
			
			totalCnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
		    String tree = entry.getKey();
		    int count = entry.getValue();
		    
		    sb.append(tree).append(" ");
		    
		    double percentage = (double) count / totalCnt * 100.0;
		    sb.append(String.format("%.4f", percentage)).append("\n");
		}
			
		System.out.print(sb);
	}
}