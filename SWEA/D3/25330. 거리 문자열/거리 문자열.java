import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String input = br.readLine();

            int[][] arr = new int[10][3];

            for (int i = 0; i < 10; i++) {
                arr[i][1] = -1;
            }

            for (int i = 0; i < input.length(); i++) {
                int num = input.charAt(i) - '0';
                arr[num][0]++;

                if (arr[num][1] == -1) {
                    arr[num][1] = i;
                } else {
                    arr[num][2] = i;

                }
            }

            boolean isOk = true;

            for (int i = 0; i < 10; i++) {
                if (arr[i][0] != 2 && arr[i][0] != 0) {
                    isOk = false;
                    break;
                }

                if (arr[i][0] == 2) {
                    if (Math.max(arr[i][1], arr[i][2]) - Math.min(arr[i][1], arr[i][2]) != i + 1) {
                        isOk = false;
                        break;
                    }
                }
            }

            if (isOk) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}