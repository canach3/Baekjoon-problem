import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] students = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int exam1 = Integer.parseInt(st.nextToken());
                int exam2 = Integer.parseInt(st.nextToken());
                int lecture = Integer.parseInt(st.nextToken());

                int total = (exam1 * 35) + (exam2 * 45) + (lecture * 20);

                students[i][0] = i;
                students[i][1] = total;
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (students[j][1] < students[j + 1][1]) {
                        int[] temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }

            int rank = 0;
            for (int i = 0; i < N; i++) {
                if (students[i][0] == K - 1) {
                    rank = i;
                }
            }

            System.out.println("#" + testCase + " " + grades[rank / (N / 10)]);
        }
    }
}