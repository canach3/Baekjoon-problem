import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int time = sc.nextInt();

        int ball = 1;
        for (int i = 0; i < time; i++) {
            int cup1 = sc.nextInt();
            int cup2 = sc.nextInt();

            if (cup1 == ball) {
                ball = cup2;
            } else if (cup2 == ball) {
                ball = cup1;
            }

        }

        System.out.println(ball);
    }
}