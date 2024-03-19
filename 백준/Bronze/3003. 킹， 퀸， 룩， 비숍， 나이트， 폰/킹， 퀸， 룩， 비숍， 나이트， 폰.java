import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] blackPiece = {1, 1, 2, 2, 2, 8};
        int[] whitePiece = new int[6];

        for (int i = 0; i < whitePiece.length; i++) {
            whitePiece[i] = sc.nextInt();
        }

        for (int i = 0; i < blackPiece.length; i++) {
            System.out.print(blackPiece[i] - whitePiece[i] + " ");
        }
    }
}