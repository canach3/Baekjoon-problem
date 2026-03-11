import java.io.*;
import java.util.*;

public class Solution {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            
            List<Integer>[] tasteList = new ArrayList[101];
            for (int i = 1; i <= 100; i++) {
                tasteList[i] = new ArrayList<>();
            }
            
            int maxTaste = 0;
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    int taste = Integer.parseInt(st.nextToken());
                    tasteList[taste].add(r * N + c); 
                    if (taste > maxTaste) maxTaste = taste;
                }
            }
            
            parent = new int[N * N];
            for (int i = 0; i < N * N; i++) {
                parent[i] = i;
            }
            
            boolean[] active = new boolean[N * N];
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            
            int maxCnt = 1; 
            int currentCnt = 0;
            
            for (int t = maxTaste; t >= 1; t--) {
                if (tasteList[t].isEmpty()) continue;
                
                for (int idx : tasteList[t]) {
                    active[idx] = true;
                    currentCnt++;
                    
                    int r = idx / N;
                    int c = idx % N;
                    
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            int nextIdx = nr * N + nc;
                            
                            if (active[nextIdx]) {
                                if (union(idx, nextIdx)) {
                                    currentCnt--; 
                                }
                            }
                        }
                    }
                }
                maxCnt = Math.max(maxCnt, currentCnt);
            }
            
            sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); 
    }
    
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) return false; 
        
        parent[rootB] = rootA;
        return true;
    }
}