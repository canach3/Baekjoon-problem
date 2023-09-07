import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        int cnt = 1;
        int[] restArray = new int[10];

        for (int i = 0; i < 10; i++) {
            n = sc.nextInt();
            restArray[i] = n % 42;
        }
        Arrays.sort(restArray);

        for (int i = 1; i < 10; i++) {
            if (restArray[i] != restArray[i - 1]) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}