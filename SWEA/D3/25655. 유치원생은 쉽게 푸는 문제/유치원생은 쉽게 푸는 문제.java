import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tesCase = 1; tesCase <= T; tesCase++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 1) {
                System.out.print(0);
            } else if (N % 2 == 0) {
                for (int i = 1; i <= N / 2; i++) {
                    System.out.print(8);
                }
            } else {
                System.out.print(4);
                for (int i = 1; i <= N / 2; i++) {
                    System.out.print(8);
                }
            }

            System.out.println();
        }
    }
}