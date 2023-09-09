import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scoreArr = new double[n];
        int maxScore = 0;
        double average = 0;

        // 점수 배열
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            scoreArr[i] = score;
            if (maxScore < score) {
                maxScore = score;
            }
        }

        for (int i = 0; i < scoreArr.length; i++) {
            scoreArr[i] = scoreArr[i] / maxScore * 100;
            average += scoreArr[i];
        }
        System.out.println(average / n);
    }
}