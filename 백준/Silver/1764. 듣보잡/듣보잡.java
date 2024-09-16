import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Set<String> set1 = new HashSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            set1.add(sc.nextLine());
        }

        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String input = sc.nextLine();

            if (set1.contains(input)) {
                set2.add(input);
            }
        }

        int cnt = set2.size();

        List<String> list = new ArrayList<>(set2);
        Collections.sort(list);

        sb.append(cnt).append("\n");
        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}