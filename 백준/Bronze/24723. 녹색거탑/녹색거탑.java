import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        double result = calculateCase(height);
        System.out.println((int)result);
    }
    
    static double calculateCase(int height) {
        return Math.pow(2, height);
    }
}