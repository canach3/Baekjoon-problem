import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        int[] ACGTStandard = new int[4];
        int[] ACGTInput = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ACGTStandard[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            if (DNA.charAt(i) == 'A') {
                ACGTInput[0]++;
            }
            if (DNA.charAt(i) == 'C') {
                ACGTInput[1]++;
            }
            if (DNA.charAt(i) == 'G') {
                ACGTInput[2]++;
            }
            if (DNA.charAt(i) == 'T') {
                ACGTInput[3]++;
            }
        }

        int left = 0;
        int right = P - 1;
        int cnt = 0;

        if (ACGTInput[0] >= ACGTStandard[0] && ACGTInput[1] >= ACGTStandard[1] &&
            ACGTInput[2] >= ACGTStandard[2] && ACGTInput[3] >= ACGTStandard[3]) {
            cnt++;
        }

        while (right < S - 1) {
            left++;
            right++;

            if (DNA.charAt(left-1) == 'A') {
                ACGTInput[0]--;
            }
            if (DNA.charAt(left-1) == 'C') {
                ACGTInput[1]--;
            }
            if (DNA.charAt(left-1) == 'G') {
                ACGTInput[2]--;
            }
            if (DNA.charAt(left-1) == 'T') {
                ACGTInput[3]--;
            }

            if (DNA.charAt(right) == 'A') {
                ACGTInput[0]++;
            }
            if (DNA.charAt(right) == 'C') {
                ACGTInput[1]++;
            }
            if (DNA.charAt(right) == 'G') {
                ACGTInput[2]++;
            }
            if (DNA.charAt(right) == 'T') {
                ACGTInput[3]++;
            }

            if (ACGTInput[0] >= ACGTStandard[0] && ACGTInput[1] >= ACGTStandard[1] &&
                ACGTInput[2] >= ACGTStandard[2] && ACGTInput[3] >= ACGTStandard[3]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}