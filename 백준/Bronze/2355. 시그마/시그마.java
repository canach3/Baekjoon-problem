import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		if(a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		
		long sum = (b + a) * ((b-a)/2 + 1);
		
		if((a + b) % 2 == 0) sum -= (a + b) / 2;
		
		System.out.println(sum);
	}
}