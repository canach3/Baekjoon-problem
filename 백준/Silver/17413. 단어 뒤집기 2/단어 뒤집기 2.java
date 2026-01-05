import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		boolean isOpen = false;
		int startIdx = 0;
		int endIdx = 0;
		
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '<') {
				endIdx = i - 1;
				for (int j = endIdx; j >= startIdx; j--) {
					System.out.print(S.charAt(j));
				}
				startIdx = i;
				isOpen = true;
			} else if (S.charAt(i) == '>') {
				endIdx = i;
				for (int j = startIdx; j <= endIdx; j++) {
					System.out.print(S.charAt(j));
				}
				startIdx = i + 1;
				isOpen = false;
			} else if (S.charAt(i) == ' ') {
				if (!isOpen) {
					endIdx = i - 1;
					for (int j = endIdx; j >= startIdx; j--) {
						System.out.print(S.charAt(j));
					}
					System.out.print(" ");
					startIdx = i + 1;
				}
			} else if (i == S.length() - 1) {
				endIdx = i;
				for (int j = endIdx; j >= startIdx; j--) {
					System.out.print(S.charAt(j));
				}
			}
		}
	}
}