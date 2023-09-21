import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] piece = {1, 1, 2, 2, 2, 8};
        int[] myPiece = new int[6];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < myPiece.length; i++) {
            myPiece[i] = sc.nextInt();
        }

        for (int i = 0; i < piece.length; i++) {
            System.out.print((piece[i] - myPiece[i]) + " ");
        }
    }
}