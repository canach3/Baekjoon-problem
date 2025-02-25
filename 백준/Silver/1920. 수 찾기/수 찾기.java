import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        ArrayList<Integer> nList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nList.add(sc.nextInt());
        }

        int M = sc.nextInt();
        ArrayList<Integer> mList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            mList.add(sc.nextInt());
        }

        Collections.sort(nList);

        for (int i = 0; i < M; i++) {
            int target = mList.get(i);
            int left = 0;
            int right = nList.size() - 1;
            int middle = right / 2;

            while (true) {
                if (target == nList.get(middle)) {
                    sb.append(1).append("\n");
                    break;
                }

                if (target > nList.get(middle)) {
                    left = middle + 1;
                    middle = (left + right) / 2;
                } else {
                    right = middle - 1;
                    middle = (left + right) / 2;
                }

                if (left > right) {
                    sb.append(0).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}