import java.io.*;
import java.util.*;
 
public class Solution {
	static int[] cardsA;
	static int[] cardsB;
	static boolean[] used;
	static int win;
	static int draw;
	
	static final int TOTAL = 362880;
	static final int MAX_SCORE = 171;
	
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            
            cardsA = new int[10];
            cardsB = new int[10];
            used = new boolean[19];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 9; i++) {
            	cardsA[i] = Integer.parseInt(st.nextToken());
				used[cardsA[i]] = true;
			}
            
            int idx = 1;
            for (int i = 1; i <= 18; i++) {
				if (!used[i]) cardsB[idx++] = i;
			}
            
            win = 0;
            draw = 0;
            DFS(0, 0, 0, 0);
            
            sb.append(win).append(" ").append(TOTAL - win - draw).append("\n");
        }
         
        System.out.print(sb);
    }
    
    static void DFS(int idxA, int idxB, int scoreA, int scoreB) {
    	int cardA = cardsA[idxA];
    	int cardB = cardsB[idxB];
    	
    	if (cardA > cardB) {
    		scoreA += cardA + cardB;
    	} else {
    		scoreB += cardA + cardB;
    	}
    	
    	// 종료 : 9번 대결했는데 이긴 경우
    	if (idxA == 9) {
    		if (scoreA > scoreB) win++;
    		else if (scoreA == scoreB) draw++;
    		
    		return;
    	}
    	
    	// 종료 : 지금부터 다 이겨도 지는 경우
    	int remain = MAX_SCORE - scoreA - scoreB;
    	if (scoreA + remain < scoreB) return;
    	
    	
    	for (int i = 1; i <= 9; i++) {
    		int card = cardsB[i];
    		
			if (!used[card]) {
				used[card] = true;
				
				DFS(idxA + 1, i, scoreA, scoreB);
				
				used[card] = false;
			}
		}
    }
}