import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            int[] result = isPalindrome(br.readLine());

            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.print(sb);
    }

    public static int[] recursion(String s, int l, int r, int mCnt){
        if(l >= r) return new int[] {1, mCnt};
        else if(s.charAt(l) != s.charAt(r)) return new int[]{0, mCnt};
        else return recursion(s, l+1, r-1, mCnt + 1);
    }
    public static int[] isPalindrome(String s){
        return recursion(s, 0, s.length()-1, 1);
    }
}