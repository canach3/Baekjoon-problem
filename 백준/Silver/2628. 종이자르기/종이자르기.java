import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> vertical = new ArrayList<>();
        List<Integer> horizontal = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        vertical.add(0);
        vertical.add(width);
        horizontal.add(0);
        horizontal.add(height);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cut = Integer.parseInt(st.nextToken());
            int cutNum = Integer.parseInt(st.nextToken());

            if (cut == 0) {
                horizontal.add(cutNum);
            } else {
                vertical.add(cutNum);
            }
        }

        Collections.sort(vertical);
        Collections.sort(horizontal);

        int vMax = 0;
        for (int i = 1; i < vertical.size(); i++) {
            int length = vertical.get(i) - vertical.get(i - 1);
            if (length > vMax) {
                vMax = length;
            }
        }

        int hMax = 0;
        for (int i = 1; i < horizontal.size(); i++) {
            int length = horizontal.get(i) - horizontal.get(i - 1);
            if (length > hMax) {
                hMax = length;
            }
        }

        int result = vMax * hMax;
        System.out.println(result);
    }
}