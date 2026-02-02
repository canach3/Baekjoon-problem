import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int sum = 0;
            int currentSpeed = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int speedAmount = 0;

                switch (command) {
                    case 0:
                        sum += currentSpeed;
                        break;
                    case 1:
                        speedAmount = Integer.parseInt(st.nextToken());
                        currentSpeed += speedAmount;
                        sum += currentSpeed;
                        break;
                    case 2:
                        speedAmount = Integer.parseInt(st.nextToken());
                        currentSpeed = Math.max((currentSpeed - speedAmount), 0);
                        sum += currentSpeed;
                        break;
                }
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }
}