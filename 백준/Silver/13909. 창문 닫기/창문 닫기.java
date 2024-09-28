import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        int i = 1;
        int j = 1;
        while (j <= n) {
            cnt++;
            i++;
            j = i * i;
        }

        System.out.println(cnt);
    }
}