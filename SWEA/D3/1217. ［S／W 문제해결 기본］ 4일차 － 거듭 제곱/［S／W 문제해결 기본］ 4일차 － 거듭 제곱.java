import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int testCase = 1; testCase <= 10; testCase++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
 
            System.out.println("#" + T + " " + exp(N, M));
        }
    }
 
    static int exp(int N, int M) {
        if (M <= 1) return N;
        
        int tmp = exp(N, M / 2);
        
        if (M % 2 == 1) {
        	return tmp * tmp * N;
        } else {
        	return tmp * tmp;
        }
    }
}