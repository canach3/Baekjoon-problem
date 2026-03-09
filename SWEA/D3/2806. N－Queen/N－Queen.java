import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
	static int[] col;
	static int ans;
	
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
             
            N = Integer.parseInt(br.readLine().trim());
            col = new int[N];
            
            ans = 0;
            make(0);
            
            sb.append(ans).append("\n");
        }
         
        System.out.print(sb);
    }
    
    static void make(int row) {
    	// 종료 조건
    	if (row == N) {
    		ans++;
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
			col[row] = i;
			
			if (isPossible(row)) {
				make(row + 1);
			}
		}
    	
    }
    
    static boolean isPossible(int row) {
    	for (int i = 0; i < row; i++) {
    		// 같은 열에 설치하는 경우
			if (col[i] == col[row]) return false;
			
			// 대각선에 설치하는 경우 (행의 차이와 열의 차이가 동일한 경우)
			if (Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
		}
    	
    	return true;
    }
}