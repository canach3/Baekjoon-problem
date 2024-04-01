import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> factorList = new ArrayList<>();

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        for (int i = n1; i <= n2; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }

            if (cnt == 2) {
                factorList.add(i);
            }
        }

        if (factorList.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = factorList.stream().mapToInt(Integer::intValue).sum();
            int minNum = factorList.get(0);

            System.out.println(sum);
            System.out.println(minNum);
        }
    }
}