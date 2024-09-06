import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++)
        {
            String temp = sc.nextLine();
            String result = temp.substring(0, 1).toUpperCase() + "" + temp.substring(1, temp.length());
            System.out.println(result);
        }
    }
}