import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            char alphabet = sc.next().charAt(0);

            if (alphabet == '#') {
                return;
            }

            String str = sc.nextLine();

            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.toLowerCase().charAt(i) == alphabet) {
                    cnt++;
                }
            }

            System.out.println(alphabet + " " + cnt);
        }
    }
}