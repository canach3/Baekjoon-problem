import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int cheapestBurger = 2000;

         for (int i = 0; i < 3; i++) {
                int burger = sc.nextInt();

                if (burger <= cheapestBurger) {
                    cheapestBurger = burger;
                }
            }


         int cheapestDrink = 2000;
         for (int i = 0; i < 2; i++) {
             int softDrink = sc.nextInt();

             if (softDrink <= cheapestDrink) {
                 cheapestDrink = softDrink;
             }
         }

        System.out.println(cheapestBurger + cheapestDrink - 50);
    }
}

