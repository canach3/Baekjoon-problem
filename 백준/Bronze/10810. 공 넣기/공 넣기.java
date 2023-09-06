import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int times = sc.nextInt();

        // 바구니 배열 선언
        int[] basArray = new int[n];

        // 바구니 배열 0으로 초기화
        for (int i = 0; i < basArray.length; i++) {
            basArray[i] = 0;
        }

        // 바구니 공 변경
        for (int i = 0; i < times; i++) {
            int first = sc.nextInt();
            int last = sc.nextInt();
            int ballNum = sc.nextInt();

            for (int j = first; j <= last - first + first; j++) {
                basArray[j-1] = ballNum;
            }
        }

        for (int i = 0; i < basArray.length; i++) {
            System.out.print(basArray[i] + " ");
        }
    }
}