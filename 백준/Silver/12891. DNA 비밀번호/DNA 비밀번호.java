import java.util.*;

public class Main {
    public static void main(String[] args) {
        // O(^2) 불가
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();

        sc.nextLine();

        String DNAString = sc.nextLine();

        // 부분 문자열에 'A', 'C', 'G', 'T' 각각이 포함되어야 할 개수를 담을 배열 생성
        // 실제로 부분 문자열에 포함되는 개수를 담을 배열도 생성
        int[] charHaving = new int[4];
        int[] charStandard = new int[4];
        for (int i = 0; i < charStandard.length; i++) {
            charStandard[i] = sc.nextInt();
        }

        // 첫 부분 문자열에서 각 문자가 포함되는 개수를 담음
        for (int i = 0; i < P; i++) {
            if (DNAString.charAt(i) == 'A') {
                charHaving[0]++;
            }

            if (DNAString.charAt(i) == 'C') {
                charHaving[1]++;
            }

            if (DNAString.charAt(i) == 'G') {
                charHaving[2]++;
            }

            if (DNAString.charAt(i) == 'T') {
                charHaving[3]++;
            }
        }
        
        // P만큼의 범위를 유지하면서 한 칸씩 이동
        // 범위에서 벗어나는 문자는 -1,
        // 범위에 추가되는 문자는 +1
        int cnt = 0;
        int startIdx = 0;
        int endIdx = P-1;
        while (true) {

            if (charHaving[0] >= charStandard[0] && charHaving[1] >= charStandard[1] && charHaving[2] >= charStandard[2] && charHaving[3] >= charStandard[3]) {
                cnt++;
            }

            if (endIdx + 1 > S - 1) {
                break;
            }

            if (DNAString.charAt(startIdx) == 'A') {
                charHaving[0]--;
            }
            if (DNAString.charAt(startIdx) == 'C') {
                charHaving[1]--;
            }
            if (DNAString.charAt(startIdx) == 'G') {
                charHaving[2]--;
            }
            if (DNAString.charAt(startIdx) == 'T') {
                charHaving[3]--;
            }

            if (DNAString.charAt(endIdx + 1) == 'A') {
                charHaving[0]++;
            }
            if (DNAString.charAt(endIdx + 1) == 'C') {
                charHaving[1]++;
            }
            if (DNAString.charAt(endIdx + 1) == 'G') {
                charHaving[2]++;
            }
            if (DNAString.charAt(endIdx + 1) == 'T') {
                charHaving[3]++;
            }

            startIdx++;
            endIdx++;
        }

        System.out.println(cnt);
    }
}