import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] ACnt = new int[5];
            int[] BCnt = new int[5];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                int shape = Integer.parseInt(st.nextToken());
                ACnt[shape]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 0; j < b; j++) {
                int shape = Integer.parseInt(st.nextToken());
                BCnt[shape]++;
            }

            for (int j = 4; j >= 1; j--) {
                if (ACnt[j] > BCnt[j]) {
                    System.out.println("A");
                    break;
                }

                if (ACnt[j] < BCnt[j]) {
                    System.out.println("B");
                    break;
                }

                if(j == 1) {
                    System.out.println("D");
                }
            }
        }
    }
}