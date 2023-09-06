
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int arrayNum = sc.nextInt();
            array[i] = arrayNum;
        }

        int v = sc.nextInt();
        int count = 0;

        for (int i : array) {
            if (i == v) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}