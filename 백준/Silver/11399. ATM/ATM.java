import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sumArr = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		sumArr[0] = arr[0];
		
		int sum = sumArr[0];
		for (int i = 1; i < N; i++) {
			sumArr[i] = sumArr[i - 1] + arr[i];
			sum += sumArr[i];
		}
			
		System.out.println(sum);
	}
}