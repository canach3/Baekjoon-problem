import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (A == 1) {
            if (B == 2) {
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        }

        if (A == 2) {
            if (B == 3) {
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        }

        if (A == 3) {
            if (B == 1) {
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        }
    }
}