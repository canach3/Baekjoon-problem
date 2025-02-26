import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int start = 0;
        int end = 0;
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            array[i] = input;
            end += input;

            if (input >= start) {
                start = input;
            }
        }

        while (start <= end) {
            int middle = (end + start) / 2;
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < array.length; i++) {
                if (sum + array[i] > middle) {
                    cnt++;
                    sum = 0;
                }
                sum += array[i];
            }

            if (sum != 0) {
                cnt++;
            }

            if (cnt > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        System.out.println(start);
    }
}