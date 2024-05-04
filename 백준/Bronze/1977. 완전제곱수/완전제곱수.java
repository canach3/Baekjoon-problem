import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minN = sc.nextInt();
        int maxN = sc.nextInt();

        int sum = 0;
        int minSquareN = maxN;

        for (int i = 1; i * i <= maxN; i++) {
            if (i * i >= minN &&  i * i <= maxN) {
                sum += i * i;

                if (i * i <= minSquareN) {
                    minSquareN = i * i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minSquareN);
        }
    }
}