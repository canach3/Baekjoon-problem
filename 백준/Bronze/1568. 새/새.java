import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long birds = sc.nextLong();
        long num = 1;
        int cnt = 0;
        
        while (birds != 0) {
            if (num > birds) {
                num = 1;
            }

            birds -= num;
            cnt++;
            num++;
        }

        System.out.println(cnt);
    }
}