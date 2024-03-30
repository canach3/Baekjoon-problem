import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> factorList = new ArrayList<>();

        int num = sc.nextInt();
        int order = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factorList.add(i);
            }
        }

        if (factorList.size() < order) {
            System.out.println(0);
        } else {
            System.out.println(factorList.get(order - 1));
        }
    }
}