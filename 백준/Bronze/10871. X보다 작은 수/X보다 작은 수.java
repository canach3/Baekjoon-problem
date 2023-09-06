import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int bigNum = sc.nextInt();
        int[] numArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            numArray[i] = sc.nextInt();
        }

        for (int smallNum : numArray) {
            if (smallNum < bigNum)
                System.out.print(smallNum + " ");
        }
    }
}