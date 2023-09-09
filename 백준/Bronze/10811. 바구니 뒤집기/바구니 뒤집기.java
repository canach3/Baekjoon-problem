import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 바구니 생성
        int[] basArray = new int[n];
        int[] reBasArray = new int[n];

        // 바구니 번호 부여
        for (int i = 0; i < n; i++) {
            basArray[i] = i + 1;
            reBasArray[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();

            for (int j = first - 1; j <= last - 1; j++) {
                reBasArray[last + first - 2 - j] = basArray[j];
            }
            for (int j = first - 1; j <= last - 1; j++) {
                basArray[j] = reBasArray[j];
            }

        }
        for (int i = 0; i < basArray.length; i++) {
            System.out.print(basArray[i] + " ");
        }
    }
}