import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            N = Integer.parseInt(br.readLine().trim());
            int[] blocks = new int[N + 2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                blocks[i] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            for (int i = 1; i <= N; i++) {
                int[] arr = Arrays.copyOf(blocks, blocks.length);
                int left = i - 1;
                int right = i + 1;

                int score = 0;
                if (arr[left] == 0 || arr[right] == 0) {
                    if (arr[left] == 0 && arr[right] == 0) score = arr[i];
                    else if (arr[left] == 0) score = arr[right];
                    else score = arr[left];
                } else {
                    score = arr[left] * arr[right];
                }

                arr[i] = 0;

                DFS(arr, score, 2);
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int[] blocks, int scoreSum, int cnt) {

        if (cnt > N) {
            if (scoreSum > max) max = scoreSum;
            return; // N번 다 깨면 종료
        }

        for (int i = 1; i <= N; i++) {
            if (blocks[i] != 0) {
                int[] arr = Arrays.copyOf(blocks, blocks.length);
                int left = i - 1;
                int right = i + 1;

                while (left > 0 ) {
                    if (arr[left] != 0) break;
                    left--;
                }

                while (right < N) {
                    if (arr[right] != 0) break;
                    right++;
                }

                int score = 0;
                if (arr[left] == 0 || arr[right] == 0) {
                    if (arr[left] == 0 && arr[right] == 0) score = arr[i];
                    else if (arr[left] == 0) score = arr[right];
                    else score = arr[left];
                } else {
                    score = arr[left] * arr[right];
                }

                arr[i] = 0;

                DFS(arr, scoreSum + score, cnt + 1);
            }
        }
    }
}