import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int date = sc.nextInt();

        int violate = 0;
        for (int i = 0; i < 5; i++) {
            int carNum = sc.nextInt();
            
            if (date == carNum) {
                violate++;
            }
        }

        System.out.println(violate);
    }
}