import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> origin = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            origin.add(sc.nextInt());
        }

        List<Integer> sorted = new ArrayList<>(origin);
        Collections.sort(sorted);

        HashMap<Integer, Integer> numMap = new HashMap<>();
        int rank = 0;
        for(int i : sorted) {
            if(!numMap.containsKey(i)) {
                numMap.put(i, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
            int ranking = numMap.get(key);	// 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}