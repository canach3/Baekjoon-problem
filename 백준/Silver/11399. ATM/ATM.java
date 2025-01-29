import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] line = new int[N];

        for (int i = 0; i < N; i++) {
            line[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (line[j] <= line[j - 1]) {
                    int temp = line[j];
                    line[j] = line[j - 1];
                    line[j-1] = temp;
                }
            }
        }


        int[] sumArr = new int[N];
        sumArr[0] = line[0];
        int sum = line[0];
        for (int i = 1; i < line.length; i++) {
            sumArr[i] = sumArr[i-1] + line[i];
            sum += sumArr[i];
        }

        System.out.println(sum);
    }
}