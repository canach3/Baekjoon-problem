
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int[] alphabet = new int[26];
        boolean isGroupWord;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            isGroupWord = true;

            for (int j = 0; j < 26; j++)
                alphabet[j] = 0;

            alphabet[(int)(word.charAt(0) - 97)] = 1;

            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j) != word.charAt(j - 1)) {
                    if (alphabet[(int)(word.charAt(j) - 97)] == 0) {
                        alphabet[(int)(word.charAt(j) - 97)] = 1;
                    } else {
                        isGroupWord = false;
                        break;
                    }
                }
            }

            if (isGroupWord) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}