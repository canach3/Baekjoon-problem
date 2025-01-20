import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] sumArr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i-1] + i;
        }

        int cnt = 0;
        int startIdx = 0;
        int endIdx = 1;
        while(startIdx <= N && endIdx <= N) {
            int sum = sumArr[endIdx] - sumArr[startIdx];

            if (sum < N) {
                endIdx++;
            } else if (sum > N) {
                startIdx++;
            } else {
                cnt++;
                endIdx++;
            }
        }

        System.out.println(cnt);
    }
}