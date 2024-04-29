import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Integer[] arr = new Integer[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int n : arr) {
            System.out.print(n);
        }
    }
}