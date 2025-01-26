import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        for (int i = N; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (numArr[j] <= numArr[j - 1]) {
                    int temp = numArr[j];
                    numArr[j] = numArr[j - 1];
                    numArr[j - 1] = temp;
                }
            }
        }

        for (int num : numArr) {
            System.out.println(num);
        }
    }
}