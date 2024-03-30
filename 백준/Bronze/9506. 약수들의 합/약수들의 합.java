import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            ArrayList<Integer> factorList = new ArrayList<>();

            int num = sc.nextInt();

            if (num == -1) {
                break;
            }

            int sum = 0;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    factorList.add(i);
                    sum += i;
                }
            }

            if (num == sum + 1) {
                System.out.print(num + " = 1");
                for ( int factor : factorList) {
                    System.out.print(" + " + factor);
                }

                System.out.println();
            } else {
                System.out.println(num + " is NOT perfect.");
            }
        }
    }
}