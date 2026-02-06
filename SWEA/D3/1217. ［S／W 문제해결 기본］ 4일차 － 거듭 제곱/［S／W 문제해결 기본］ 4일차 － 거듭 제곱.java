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
        return N * exp(N, M - 1);
    }
}