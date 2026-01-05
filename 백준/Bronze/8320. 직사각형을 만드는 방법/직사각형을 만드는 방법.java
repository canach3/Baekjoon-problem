import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			int totalSquare = i * i;
			while (totalSquare <= N) {
				cnt++;
				totalSquare += i;
			}
		}
		
		System.out.println(cnt);
	}
}