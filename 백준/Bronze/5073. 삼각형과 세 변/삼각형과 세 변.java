import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int side1 = sc.nextInt();
            int side2 = sc.nextInt();
            int side3 = sc.nextInt();
            
            if (side1 == 0 || side2 == 0 || side3 == 0) {
                break;
            } else if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2) {
                System.out.println("Invalid");
            } else if (side1 == side2 && side2 == side3) {
                System.out.println("Equilateral");
            } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}