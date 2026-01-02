import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		arr[0] = 10000;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int students = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < students; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int j = num; j < arr.length; j++) {
					if (j % num == 0) {
						if (arr[j] == 1 ) {
							arr[j] = 0;
						} else {
							arr[j] = 1;
						}
					}
				}
			}
			
			if (gender == 2) {
				if (arr[num] == 0) {
					arr[num] = 1;
				} else {
					arr[num] = 0;
				}
				
				int left = num - 1;
				int right = num + 1;
				
				while (left >= 1 && right <= N && (arr[left] == arr[right])) {
					if (arr[left] == 0) {
						arr[left] = 1;
						arr[right] = 1;
					} else {
						arr[left] = 0;
						arr[right] = 0;
					}
					
					left--;
					right++;
				}
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}