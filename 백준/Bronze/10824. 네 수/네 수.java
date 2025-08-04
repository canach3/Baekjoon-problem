import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input1 = sc.next();
        String input2 = sc.next();
        String input3 = sc.next();
        String input4 = sc.next();

        long num1 = Long.parseLong(input1 + input2);
        long num2 = Long.parseLong(input3 + input4);

        System.out.println(num1 + num2);
    }
}