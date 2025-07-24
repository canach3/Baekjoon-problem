import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        int sum = 0;
        int result = 0;
        Arrays.sort(numArr);

        for (int i = 0; i < N; i++) {
            sum += numArr[i];
            result += sum;
        }

        System.out.println(result);
    }
}