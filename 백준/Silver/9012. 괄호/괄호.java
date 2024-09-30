import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            int left = 0;
            int right = 0;

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    left++;
                } else {
                    right++;
                }

                if (right > left) {
                    break;
                }
            }

            if (left == right) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}