import java.util.*;

public class Main {
    public static void main(String[] args) {
        // O(N^2) 까지는 괜찮음
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }
        Arrays.sort(numArr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int checkNum = numArr[i];
            int startIdx = 0;
            int endIdx = N-1;

            while (startIdx < endIdx) {
                int sum = numArr[endIdx] + numArr[startIdx];
                if (sum < checkNum) {
                    startIdx++;
                } else if (sum > checkNum) {
                    endIdx--;
                } else {
                    if (startIdx != i && endIdx != i) {
                        cnt++;
                        break;
                    } else if (startIdx == i) {
                        startIdx++;
                    } else {
                        endIdx--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}