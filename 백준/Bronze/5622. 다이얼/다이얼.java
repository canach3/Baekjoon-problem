
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char[] charArray = input.toCharArray();

        int totalS = 0;

        for (int i = 0; i < charArray.length; i++) {
            if (((int) charArray[i] - 65) == 18) {
                totalS += 8;
            } else if (((int) charArray[i] - 65) == 21) {
                totalS += 9;
            } else if (((int) charArray[i] - 65) == 24 || ((int) charArray[i] - 65) == 25) {
                totalS += 10;
            } else {
                totalS += ((int) charArray[i] - 65) / 3 + 3;
            }
        }

        System.out.println(totalS);

        sc.close();
    }
}