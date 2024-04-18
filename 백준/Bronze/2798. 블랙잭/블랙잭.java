import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int maxN = sc.nextInt();

        int[] cardArr = new int[n];

        for (int i = 0; i < n; i++) {
            cardArr[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cardArr[i] + cardArr[j] + cardArr[k];
                    if (sum >= result && sum <= maxN) {
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}