import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            boolean clap = false;
            String num = Integer.toString(i);

            for (int j = 0; j < num.length(); j++) {
                if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
                    clap = true;
                    System.out.print("-");
                }
            }

            if (!clap) {
                System.out.print(i);
            }

            System.out.print(" ");
        }
    }
}