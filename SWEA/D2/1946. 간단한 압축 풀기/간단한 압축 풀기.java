import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] alphabets = new int[26];
            int[] orders = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int alphabet = st.nextToken().charAt(0) - 65;
                alphabets[alphabet] += Integer.parseInt(st.nextToken());
                orders[i] = alphabet;
            }

            System.out.println("#" + testCase);

            int time = 0;
            for (int i = 0; i < N; i++) {
                int alphabet = orders[i];

                while (alphabets[alphabet] > 0) {
                    time++;
                    System.out.print((char) (alphabet + 'A'));
                    alphabets[alphabet]--;

                    if (time == 10) {
                        System.out.println();
                        time = 0;
                    }
                }
            }
            System.out.println();
        }
    }
}