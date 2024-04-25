import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);

        for (int num : numArr) {
            System.out.println(num);
        }
    }
}