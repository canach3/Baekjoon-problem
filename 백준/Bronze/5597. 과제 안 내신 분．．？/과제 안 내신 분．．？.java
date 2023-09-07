import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] studentArray = new int[30];
        int submitO;
        for (int i = 0; i < 30; i++) {
            studentArray[i] = i + 1;
        }

        for (int i = 0; i < 28; i++) {
            submitO = sc.nextInt();
            for (int j = 0; j < 30; j++) {
                if (studentArray[j] == submitO) {
                    studentArray[j] = 0;
                }
            }
        }
        Arrays.sort(studentArray);

        for (int i = 0; i < 30; i++) {
            if (studentArray[i] != 0) {
                System.out.println(studentArray[i]);
            }
        }
    }
}