import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = sc.nextLine();
        char[] numArr = input.toCharArray();

        Arrays.sort(numArr);

        for (int i = numArr.length-1; i >= 0; i--) {
            sb.append(numArr[i]);
        }

        System.out.println(sb);
    }
}