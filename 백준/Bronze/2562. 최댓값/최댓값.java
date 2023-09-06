import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numArray = new int[9];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = sc.nextInt();
        }

        int maxNum = 0;
        int maxIndex = 0;

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] >= maxNum) {
                maxNum = numArray[i];
                maxIndex = i + 1;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxIndex);
    }
}