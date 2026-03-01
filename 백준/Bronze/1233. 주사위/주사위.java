import java.util.*;
import java.io.*;

public class Main {
    static int[] diceArr;
    static int[] sumArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        diceArr = new int[3];
        diceArr[0] = Integer.parseInt(st.nextToken());
        diceArr[1] = Integer.parseInt(st.nextToken());
        diceArr[2] = Integer.parseInt(st.nextToken());

        sumArr = new int[diceArr[0] + diceArr[1] + diceArr[2] + 1];

        DFS(0, 0);

        int result = 0;
        for (int i = 1; i < sumArr.length; i++) {
            if (sumArr[i] > sumArr[result]) {
                result = i;
            }
        }

        System.out.println(result);
    }

    static void DFS(int cnt, int sum) {
        if (cnt == 3) {
            sumArr[sum]++;
            return;
        }

        for (int i = 1; i <= diceArr[cnt]; i++) {
            DFS(cnt + 1, sum + i);
        }
    }
}