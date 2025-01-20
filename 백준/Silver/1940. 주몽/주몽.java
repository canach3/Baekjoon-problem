import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력을 받음
        int N = sc.nextInt();

        // M 입력을 받음
        int M = sc.nextInt();

        // num 입력을 배열로 받고 정렬
        int[] numArr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            numArr[i] = sc.nextInt();
        }
        Arrays.sort(numArr);

        // 투 포인터 활용, 두 재료의 합 = N 이 되는 경우를 찾음  O(2N)
        int cnt = 0;
        int startIdx = 1;
        int endIdx = N;
        while (startIdx < endIdx) {
            int sum = numArr[endIdx] + numArr[startIdx];

            if (sum < M) {
                startIdx++;
            } else if (sum > M) {
                endIdx--;
            } else {
                cnt++;
                startIdx++;
            }
        }

        System.out.println(cnt);
    }
}