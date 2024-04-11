import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] stickArr = new int[3];
        int perimeter = 0;

        for (int i = 0; i < 3; i++) {
            stickArr[i] = sc.nextInt();
        }

        Arrays.sort(stickArr);

        if (stickArr[2] >= stickArr[0] + stickArr[1]) {
            perimeter = stickArr[0] + stickArr[1] + (stickArr[0] + stickArr[1] - 1);
        } else {
            perimeter = stickArr[0] + stickArr[1] + stickArr[2];
        }

        System.out.println(perimeter);
    }
}