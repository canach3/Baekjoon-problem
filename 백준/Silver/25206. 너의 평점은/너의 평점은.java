import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String subject;
        String grade;
        double credit;
        double creditSum = 0;
        double score = 0;
        double sum = 0;

        for (int i = 0; i < 20; i++) {
            subject = sc.next();
            credit = sc.nextDouble();
            grade = sc.next();

            if (grade.equals("P")) {
                continue;
            }
            else {
                creditSum += credit;

                switch (grade) {
                    case "A+":
                        score = 4.5;
                        break;
                    case "A0":
                        score = 4.0;
                        break;
                    case "B+":
                        score = 3.5;
                        break;
                    case "B0":
                        score = 3.0;
                        break;
                    case "C+":
                        score = 2.5;
                        break;
                    case "C0":
                        score = 2.0;
                        break;
                    case "D+":
                        score = 1.5;
                        break;
                    case "D0":
                        score = 1.0;
                        break;
                    case "F":
                        score = 0.0;
                        break;
                }
            }
            sum += credit * score;
        }
        System.out.println(sum / creditSum);
    }
}