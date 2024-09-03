import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numList.add(sc.nextInt());
        }

        Collections.sort(numList);

        int numA = numList.get(0);
        int numB = numList.get(1);
        int numC = numList.get(2);

        sc.nextLine();
        String order = sc.nextLine();

        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i) == 'A') {
                System.out.print(numA + " ");
            } else if (order.charAt(i) == 'B') {
                System.out.print(numB + " ");
            } else {
                System.out.print(numC + " ");
            }
        }
    }
}