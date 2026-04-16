import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Wire[] wires = new Wire[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(wires);

        int[] LIS = new int[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            int key = wires[i].b;

            if (len == 0 || LIS[len - 1] < key) {
                LIS[len] = key;
                len++;
            }
            else {
                int lo = 0;
                int hi = len - 1;

                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (LIS[mid] < key) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }

                LIS[lo] = key;
            }
        }

        System.out.println(N - len);
    }

    static class Wire implements Comparable<Wire> {
        int a;
        int b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }

        // A 전봇대 위치를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Wire o) {
            return Integer.compare(this.a, o.a);
        }
    }
}