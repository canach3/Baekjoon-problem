import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int NA = Integer.parseInt(st.nextToken());
            int NB = Integer.parseInt(st.nextToken());

            int[] arrA = new int[NA];
            int[] arrB = new int[NB];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < NA; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < NB; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            char result = ' ';

            if (NA == NB) {
                for (int i = 0; i < NA; i++) {
                    if (arrA[i] != arrB[i]) {
                        result = '?';
                        break;
                    }

                    result = '=';
                }
            } else {
                if (NA > NB) {
                    int cnt = 0;
                    for (int i = 0; i < NA; i++) {
                        for (int j = 0; j < NB; j++) {
                            if (arrA[i] == arrB[j]) {
                                cnt++;
                            }
                        }
                    }

                    if (cnt == NB) {
                        result = '>';
                    } else {
                        result = '?';
                    }
                } else {
                    int cnt = 0;
                    for (int i = 0; i < NB; i++) {
                        for (int j = 0; j < NA; j++) {
                            if (arrB[i] == arrA[j]) {
                                cnt++;
                            }
                        }
                    }

                    if (cnt == NA) {
                        result = '<';
                    } else {
                        result = '?';
                    }
                }
            }

            System.out.println(result);
        }
    }
}