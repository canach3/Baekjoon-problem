import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'C' && str.charAt(i) != 'A' && str.charAt(i) != 'M' && str.charAt(i) != 'B' && str.charAt(i) != 'R' && str.charAt(i) != 'I' && str.charAt(i) != 'D' && str.charAt(i) != 'G' && str.charAt(i) != 'E') {
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb);
    }
}