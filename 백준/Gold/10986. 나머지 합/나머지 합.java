import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();


        // N 크기 구간합 배열 생성, 값 집어넣기
        long[] sumArr = new long[N];
        sumArr[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            sumArr[i] = sumArr[i - 1] + sc.nextInt();
        }

        // 같은 나머지의 인덱스를 카운트하는 배열 생성
        long[] cntArr = new long[M];
        long result = 0;

        for (int i = 0; i < N; i++) {
            int remainder = (int) (sumArr[i] % M);
            if (remainder == 0) {
                result++;
            }

            cntArr[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (cntArr[i] > 1) {
                result = result + (cntArr[i] * (cntArr[i] - 1) / 2);
            }
        }

        System.out.println(result);
    }
}