import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int terms = sc.nextInt();

        for (int i = 0; i < terms; i++) {

            int subject = sc.nextInt();
            int totalCredit = 0;
            double GPA = 0;

            for (int j = 0; j < subject; j++) {
                int credit = sc.nextInt();
                double grade = sc.nextDouble();

                totalCredit += credit;
                GPA += credit * grade;
            }

            System.out.print(totalCredit + " ");
            System.out.printf("%.1f", GPA / totalCredit);
            System.out.println();
        }
    }
}