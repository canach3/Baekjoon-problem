import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            String s = sc.nextLine();

            if (s.equals("END")) {
                return;
            }

            List<Character> characterList = new ArrayList<>();

            char[] charArray = s.toCharArray();

            for (char c : charArray) {
                characterList.add(c);
            }

            Collections.reverse(characterList);

            for (Character c : characterList) {
                System.out.print(c);
            }

            System.out.println();
        }
    }
}