import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int winner = 0;
        int winnersScore = 0;

        for (int i = 0; i < 5; i++) {
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();
            int score4 = sc.nextInt();

            int sum = score1 + score2 + score3 + score4;

            if (sum > winnersScore) {
                winnersScore = sum;
                winner = i + 1;
            }
        }

        System.out.println(winner + " " + winnersScore);
    }
}

