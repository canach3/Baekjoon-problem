import java.io.*;
import java.util.*;

// https://www.grepiu.com/post/9
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> memberMap = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String state = sc.next();

            if (memberMap.containsKey(name)) {
                memberMap.remove(name);
            } else {
                memberMap.put(name, state);
            }
        }

        ArrayList<String> memberList = new ArrayList<>(memberMap.keySet());
        Collections.sort(memberList);
        Collections.reverse(memberList);

        for (String member : memberList) {
            System.out.println(member);
        }
    }
}
