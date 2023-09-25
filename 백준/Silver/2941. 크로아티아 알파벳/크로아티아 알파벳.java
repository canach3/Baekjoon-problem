
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int cnt = 0;

        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 2) {
                if ((word.charAt(i + 1) == '=') || (word.charAt(i + 1) == '-') || (word.charAt(i) == 'l' && word.charAt(i + 1) =='j') || (word.charAt(i) == 'n' && word.charAt(i + 1) =='j')) {
                    cnt++;
                    break;
                } else {
                    cnt += 2;
                    break;
                }
            } else if (i == word.length() - 1) {
                cnt++;
                break;
            } else if (word.charAt(i) == 'd' && word.charAt(i + 1) == 'z' && word.charAt(i + 2) == '=') {
                cnt++;
                i += 2;
            } else if ((word.charAt(i) == 'l' && word.charAt(i + 1) == 'j') || (word.charAt(i) == 'n' && word.charAt(i + 1) == 'j')) {
                cnt++;
                i++;
            } else if ((word.charAt(i + 1) == '=') || (word.charAt(i + 1) == '-')) {
                cnt++;
                i++;
            } else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}