import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Conference> minheap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            minheap.add(new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int cnt = 1;
        long endTime = minheap.remove().end;
        while (!minheap.isEmpty()) {
            Conference nextConference = minheap.remove();

            if (nextConference.start < endTime) {
                continue;
            }

            endTime = nextConference.end;
            cnt++;
        }

        System.out.println(cnt);
    }

    static class Conference implements Comparable<Conference> {
        long start;
        long end;

        public Conference(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if (end > o.end) {
                return 1;
            }

            if (end == o.end) {
                if (start >= o.start) {
                    return 1;
                } else {
                    return -1;
                }
            }

            return -1;
        }
    }
}