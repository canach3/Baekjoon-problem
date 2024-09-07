import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String hero = sc.nextLine();

            int cntG = 0;
            int cntB = 0;
            for (int j = 0; j < hero.length(); j++) {
                if (hero.charAt(j) == 'G' | hero.charAt(j) == 'g') {
                    cntG++;
                }

                if (hero.charAt(j) == 'B' || hero.charAt(j) == 'b') {
                    cntB++;
                }
            }

            System.out.print(hero + " is ");

            if (cntG > cntB) {
                System.out.println("GOOD");
            } else if (cntG < cntB) {
                System.out.println("A BADDY");
            } else {
                System.out.println("NEUTRAL");
            }
        }
    }
}