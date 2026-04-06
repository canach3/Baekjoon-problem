import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Word> words = new TreeSet<>();
        Map<String, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.length() < M) continue;

            int cnt = cntMap.getOrDefault(input, 0);
            if (cnt == 0) cntMap.put(input, 0);

            Word word = new Word(input, input.length(), cnt);
            words.remove(word);

            word.cnt++;
            words.add(word);

            cntMap.replace(input, cntMap.get(input) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word.str).append("\n");
        }

        System.out.print(sb);
    }

    static class Word implements Comparable<Word> {
        String str;
        int len;
        int cnt;

        Word(String str, int len, int cnt) {
            this.str = str;
            this.len = len;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (Integer.compare(o.cnt, this.cnt) == 0) {
                if (Integer.compare(o.len, this.len) == 0) {
                    return this.str.compareTo(o.str);
                }

                return Integer.compare(o.len, this.len);
            }

            return Integer.compare(o.cnt, this.cnt);
        }
    }
}