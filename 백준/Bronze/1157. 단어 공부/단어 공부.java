import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int[26];
        String s = sc.next().toUpperCase();

        for (int i = 0; i < s.length(); i++) {
            alphabet[(int) s.charAt(i) - 65]++;


        }

        int maxIdx = 0;

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > alphabet[maxIdx]) {
                maxIdx = i;
            }
        }

        int count = 0;

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == alphabet[maxIdx]) {
                count++;
                if (count >= 2) {
                    System.out.println("?");
                    return;
                }
            }
        }

        System.out.println((char) (maxIdx + 65));
    }
}