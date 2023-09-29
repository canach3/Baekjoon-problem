
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] numArray = new int[9][9];
        int maxNum = 0;
        int maxNumRow = 0;
        int maxNumCol = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                numArray[i][j] = sc.nextInt();
                if (numArray[i][j] >= maxNum) {
                    maxNum = numArray[i][j];
                    maxNumRow = i + 1;
                    maxNumCol = j + 1;
                }
            }
        }
        System.out.println(maxNum);
        System.out.println(maxNumRow + " " + maxNumCol);
    }
}
