import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			String result;
			
			if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
				result = "d";
			} else if (y1 == q2 || y2 == q1) {
				if (p1 == x2 || x1 == p2) {
					result = "c";
				}  else {
					result = "b";
				}
			} else if (x1 == p2 || x2 == p1) {
				if (q1 == y2 || y1 == q2) {
					result = "c";
				} else {
					result = "b";
				}
			} else {
				result = "a";
			}
			
			System.out.println(result);
		}
	}
}