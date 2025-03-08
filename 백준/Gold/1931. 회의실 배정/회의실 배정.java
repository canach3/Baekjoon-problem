import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Meeting> minHeap = new PriorityQueue<>();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            minHeap.add(new Meeting(start, end));
        }

        int cnt = 0;
        int endTime = 0;

        while (!minHeap.isEmpty()) {
            Meeting meeting = minHeap.poll();

            if (meeting.start < endTime) {
                continue;
            }

            endTime = meeting.end;
            cnt++;
        }

        System.out.println(cnt);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }
}