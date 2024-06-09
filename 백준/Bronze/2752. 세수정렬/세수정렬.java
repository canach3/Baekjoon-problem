import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numArr = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numArr.add(sc.nextInt());
        }

        Collections.sort(numArr);

        for (Integer num : numArr) {
            System.out.print(num + " ");
        }
    }
}

