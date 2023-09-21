
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int[26];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = 0;
        }
        String word = sc.nextLine();

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {

                if ((int)word.charAt(i) >= 97) {
                    if ((int)word.charAt(i) - 97 == j) {
                        alphabet[(int)word.charAt(i) - 97] += 1;
                    }

                } else {
                    if ((int)word.charAt(i) - 65 == j) {
                        alphabet[(int) word.charAt(i) - 65] += 1;
                    }
                }
            }
        }
        int maxNum = 0;
        int maxIndex = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] >= maxNum)
            {
                maxNum = alphabet[i];
                maxIndex = i;
            }
        }

        int cnt = 0;

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == maxNum) {
                cnt += 1;
            }
        }
        if(cnt >= 2) {
            System.out.println("?");
        } else {
            System.out.println((char)(maxIndex + 65));
        }
    }
}