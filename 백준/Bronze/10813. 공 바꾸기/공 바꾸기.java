import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int chTimes = sc.nextInt();
        int[] basArr = new int[n];

        // basket 번호 부여 1 ~ n
        for (int i = 0; i < n; i++) {
            basArr[i] = i + 1;
        }

        // 공 교환
        for (int i = 0; i < chTimes; i++) {
            int temp;
            int basN1 = sc.nextInt();
            int basN2 = sc.nextInt();

            temp = basArr[basN1 - 1];
            basArr[basN1 - 1] = basArr[basN2 - 1];
            basArr[basN2 - 1] = temp;
        }

        for (int i = 0; i < basArr.length; i++) {
            System.out.print(basArr[i] + " ");
        }
    }
}