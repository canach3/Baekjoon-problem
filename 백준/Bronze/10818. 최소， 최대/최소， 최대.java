import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numArray[] = new int[n];

        for (int i = 0; i < n; i++) {
            numArray[i] = sc.nextInt();
        }

        int smallest = numArray[0];
        int biggest = numArray[0];

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] < smallest) {
                smallest = numArray[i];
            }
        }
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] > biggest) {
                biggest = numArray[i];
            }
        }
        System.out.println(smallest + " " + biggest);
    }
}