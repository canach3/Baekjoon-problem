import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            String name = sc.nextLine();

            if (name.contains("FBI")) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            System.out.println("HE GOT AWAY!");
        } else {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }
}