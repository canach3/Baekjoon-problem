import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String [] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int [] alphaIndex = new int[26];
        Arrays.fill(alphaIndex, -1);

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < alphaIndex.length; j++) {
                if (alphaIndex[j] != -1) {
                    continue;
                }
                if (input.substring(i,i+1).equals(alpha[j])) {
                    alphaIndex[j] = i;
                }
            }
        }
        for (int i = 0; i < alphaIndex.length; i++) {
            System.out.print(alphaIndex[i] + " ");
        }
        sc.close();
    }
}