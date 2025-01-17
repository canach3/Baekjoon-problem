import java.util.*;

public class Main {
    public static void main(String[] args) {
        // O(n^2) 불가
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 숫자 배열, 구간합 배열 생성, 값 집어넣기 for(N) -> O(n)
        int[] nArray = new int[N];
        int[] sumArray = new int[N];
        for (int i = 0; i < N; i++) {
            nArray[i] = sc.nextInt();

            if (i == 0) {
                sumArray[i] = nArray[i];
            } else {
                sumArray[i] = sumArray[i - 1] + nArray[i];
            }
        }

        // M번 구간합 구하기 for(M) -> O(n)
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;

            int result = 0;
            if (start < 1) {
                result = sumArray[end];
            } else {
                result = sumArray[end] - sumArray[start-1];
            }

            System.out.println(result);
        }
    }
}