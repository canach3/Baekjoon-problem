import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numList.add(sc.nextInt());
        }

        Collections.sort(numList);

        sc.nextLine();
        String order = sc.nextLine();

        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i) == 'A') {
                System.out.print(numList.get(0) + " ");
            } else if (order.charAt(i) == 'B') {
                System.out.print(numList.get(1) + " ");
            } else {
                System.out.print(numList.get(2) + " ");
            }
        }
    }
}