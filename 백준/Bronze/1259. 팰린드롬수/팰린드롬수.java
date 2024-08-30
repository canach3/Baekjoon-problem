import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String num = sc.nextLine();

            if (num.equals("0")) {
                return;
            }

            boolean isPalindrome = true;
            int start = 0;
            int end = num.length() - 1;
            
            for (int i = 0; i < (num.length() / 2); i++) {
                if (num.charAt(start++) != num.charAt(end--)) {
                    isPalindrome = false;
                }
            }

            if (isPalindrome) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}