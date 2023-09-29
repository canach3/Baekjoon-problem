
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][]word = new char[5][15];
        String input;

        for (int i = 0; i < 5; i++) {
            input = sc.nextLine();
            for (int j = 0; j < input.length(); j++) {
                word[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (word[j][i] != '\u0000') {
                    System.out.print(word[j][i]);
                }
            }
        }
    }
}
