import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alphabet = new int[26];

        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            alphabet[str.charAt(i) - 97]++;
        }

        for (int i : alphabet) {
            System.out.print(i + " ");
        }
    }
}