import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numList.add(sc.nextInt());
        }

        Collections.sort(numList);

        for (int value : numList) {
            sb.append(value).append('\n');
        }

        System.out.println(sb);
    }
}