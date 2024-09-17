import java.io.*;
import java.util.*;

// https://www.grepiu.com/post/9
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = sc.nextInt();
        int b = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a; i++) {
            set.add(sc.nextInt());
        }

        for (int i = 0; i < b; i++) {
            int input = sc.nextInt();
            if (set.contains(input)) {
                set.remove(input);
            } else {
                set.add(input);
            }
        }

        System.out.println(set.size());
    }
}