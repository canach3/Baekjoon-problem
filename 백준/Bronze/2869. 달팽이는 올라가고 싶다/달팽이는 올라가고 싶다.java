import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int upLength = sc.nextInt();
        int downLength = sc.nextInt();
        int treeLength = sc.nextInt();

        int days = (treeLength - downLength) / (upLength - downLength);

        if ((treeLength - downLength) % (upLength - downLength) != 0) {
            days++;
        }
        System.out.println(days);
    }
}