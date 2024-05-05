import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int playerN = sc.nextInt();
            int maxPrice = 0;
            String pick = "";

            for (int j = 0; j < playerN; j++) {
                int price = sc.nextInt();
                String name = sc.next();

                if (price >= maxPrice) {
                    maxPrice = price;
                    pick = name;
                }
            }

            System.out.println(pick);
        }
    }
}