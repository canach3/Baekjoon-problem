import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] boys = new int[7];
        int[] girls = new int[7];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (S == 0) {
                girls[Y]++;
            } else {
                boys[Y]++;
            }
        }

        int result = 0;

        for (int i = 1; i < boys.length ; i++) {
            result += boys[i] / K;
            if (boys[i] % K > 0) {
                result++;
            }
        }

        for (int i = 1; i < girls.length; i++) {
            result += girls[i] / K;
            if (girls[i] % K > 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}