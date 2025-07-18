import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();

        sc.nextLine();
        String DNAStr = sc.nextLine();
        char[] DNAArray = DNAStr.toCharArray();   

        int[] ACGTCheck = new int[4];
        for (int i = 0; i < 4; i++) {
            ACGTCheck[i] = sc.nextInt();
        }

        int[] ACGT = new int[4];
        for (int i = 0; i < P; i++) {
            if (DNAArray[i] == 'A') {
                ACGT[0]++;
            }

            if (DNAArray[i] == 'C') {
                ACGT[1]++;
            }

            if (DNAArray[i] == 'G') {
                ACGT[2]++;
            }

            if (DNAArray[i] == 'T') {
                ACGT[3]++;
            }
        }
        
        int cnt = 0;
        int start = 0;
        int end = P - 1;

        while (end < S) {
            if ((ACGT[0] >= ACGTCheck[0]) && (ACGT[1] >= ACGTCheck[1]) && (ACGT[2] >= ACGTCheck[2]) && (ACGT[3] >= ACGTCheck[3])) {
                cnt++;
            }

            if (DNAArray[start] == 'A') {
                ACGT[0]--;
            }
            if (DNAArray[start] == 'C') {
                ACGT[1]--;
            }
            if (DNAArray[start] == 'G') {
                ACGT[2]--;
            }
            if (DNAArray[start] == 'T') {
                ACGT[3]--;
            }
            start++;
            end++;

            if (end >= S) {
                break;
            }

            if (DNAArray[end] == 'A') {
                ACGT[0]++;
            }
            if (DNAArray[end] == 'C') {
                ACGT[1]++;
            }
            if (DNAArray[end] == 'G') {
                ACGT[2]++;
            }
            if (DNAArray[end] == 'T') {
                ACGT[3]++;
            }
        }
        System.out.println(cnt);
    }
}