import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {
            int T = Integer.parseInt(br.readLine());

            char[][] map = new char[102][102];
            for (int i = 0; i < 102; i++) {
                for (int j = 0; j < 102; j++) {
                    map[i][j] = 'x';
                }
            }

            for (int i = 1; i <= 100; i++) {
                String input = br.readLine();

                for (int j = 1; j <= 100; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            int max = 1;
            
            // 가로 홀수
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    int cnt = 1;

                    for (int k = 1; k < 51; k++) {
                        if (map[i][j - k] != map[i][j + k]) {
                            break;
                        }

                        cnt += 2;
                    }
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }

            // 세로 홀수
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    int cnt = 1;

                    for (int k = 1; k < 51; k++) {
                        if (map[j - k][i] != map[j + k][i]) {
                            break;
                        }

                        cnt += 2;
                    }
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }

            // 가로 짝수
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    int cnt = 0;

                    for (int k = 1; k < 51; k++) {
                        if (map[i][j + 1 - k] != map[i][j + k]) {
                            break;
                        }

                        cnt += 2;
                    }
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }

            // 세로 짝수
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    int cnt = 0;

                    for (int k = 1; k < 51; k++) {
                        if (map[j + 1 - k][i] != map[j + k][i]) {
                            break;
                        }

                        cnt += 2;
                    }
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }

            System.out.println("#" + T + " " + max);
        }
    }
}