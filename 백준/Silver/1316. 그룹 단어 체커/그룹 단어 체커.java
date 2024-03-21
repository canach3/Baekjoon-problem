import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;


        for (int i = 0; i < n; i++) {
            String s = sc.next();

            boolean groupWord = true;

            for (int j = 0; j <= s.length() - 3; j++) {
                String tempS = s.substring(j + 2);
                if ((s.charAt(j) != s.charAt(j + 1)) && tempS.contains(s.substring(j, j + 1))) {
                    groupWord = false;
                    break;
                }
            }

            if (groupWord) count++;
        }
        System.out.println(count);
    }
}