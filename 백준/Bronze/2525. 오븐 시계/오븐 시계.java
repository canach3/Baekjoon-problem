import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int need_m = sc.nextInt();
        
        h += (m + need_m) / 60;
        h = h % 24;
        m = (m + need_m) % 60;
        
        System.out.println(h + " " + m);
    }
}
