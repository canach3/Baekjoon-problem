import java.util.Scanner;

public class Main {
    public static int edgeDot(int n) {
        if(n == 1) {
            return 3;
        } else {
            return edgeDot(n - 1) + (edgeDot(n - 1) - 1);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(edgeDot(n) * edgeDot(n));
    }
}