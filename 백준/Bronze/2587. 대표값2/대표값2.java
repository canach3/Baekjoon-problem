import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nArr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            nArr[i] = sc.nextInt();
            sum += nArr[i];
        }

        Arrays.sort(nArr);

        System.out.println(sum / 5);
        System.out.println(nArr[2]);
    }
}