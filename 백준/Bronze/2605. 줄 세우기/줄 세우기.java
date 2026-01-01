import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;

            int ball = Integer.parseInt(st.nextToken());
            if (ball > 0) {
                for (int j = 0; j < ball; j++) {
                    int temp = arr[i - j - 1];
                    arr[i - j - 1] = arr[i - j];
                    arr[i - j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}