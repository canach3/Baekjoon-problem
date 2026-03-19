import java.io.*;

public class Main {
    static int[][] line;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        line = new int[1000001][2];

        int N = readInt();
        int M = readInt();

        // 첫 번째 역 세팅
        int first = readInt();
        int prev = first;

        for (int i = 1; i < N; i++) {
            int curr = readInt();

            // 현재역과 이전역 연결
            line[prev][1] = curr;
            line[curr][0] = prev;

            prev = curr;
        }

        // 첫 역 마지막역 연결
        line[first][0] = prev;
        line[prev][1] = first;

        for (int i = 0; i < M; i++) {
            String command = readCommand();

            switch (command) {
                case "BN":
                    sb.append(BN(readInt(), readInt())).append("\n");
                    break;
                case "BP":
                    sb.append(BP(readInt(), readInt())).append("\n");
                    break;
                case "CN":
                    sb.append(CN(readInt())).append("\n");
                    break;
                case "CP":
                    sb.append(CP(readInt())).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }

    static int BN(int n1, int n2) {
        int next = line[n1][1];
        line[n2][0] = n1;
        line[n2][1] = next;
        line[next][0] = n2;
        line[n1][1] = n2;
        return next;
    }

    static int BP(int n1, int n2) {
        int prev = line[n1][0];
        line[n2][0] = prev;
        line[n2][1] = n1;
        line[prev][1] = n2;
        line[n1][0] = n2;
        return prev;
    }

    static int CN(int n) {
        int next = line[n][1];
        int nextNext = line[next][1];
        line[n][1] = nextNext;
        line[nextNext][0] = n;
        return next;
    }

    static int CP(int n) {
        int prev = line[n][0];
        int prevPrev = line[prev][0];
        line[n][0] = prevPrev;
        line[prevPrev][1] = n;
        return prev;
    }

    static int readInt() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    static String readCommand() throws Exception {
        int c = System.in.read();
        while (c <= 32) c = System.in.read();
        char c1 = (char) c;
        char c2 = (char) System.in.read();
        return "" + c1 + c2;
    }
}