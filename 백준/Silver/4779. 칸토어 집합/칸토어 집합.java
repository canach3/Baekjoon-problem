import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input.trim());

            arr = new int[(int) Math.pow(3, N)];
            cantor(0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) sb.append("-");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void cantor(int left, int right) {
        if (left >= right) return;

        int cut = ((right - left) + 1) / 3;
        int midS = left + cut;
        int midE = left + cut * 2 - 1;

        for (int i = midS; i <= midE; i++) {
            arr[i] = 1;
        }

        cantor(left, midS - 1);
        cantor(midE + 1, right);
    }
}