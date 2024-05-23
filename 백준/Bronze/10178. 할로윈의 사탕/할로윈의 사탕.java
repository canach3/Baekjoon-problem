import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int totalPieces = sc.nextInt();
            int people = sc.nextInt();

            int quotient = totalPieces / people;
            int remainder = totalPieces % people;

            System.out.println("You get " + quotient + " piece(s) and your dad gets " + remainder + " piece(s).");
        }
    }
}