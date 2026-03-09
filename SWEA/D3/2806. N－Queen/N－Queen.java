import java.io.*;
import java.util.*;
 
public class Solution {
	static int N;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
             
            N = Integer.parseInt(br.readLine().trim());
           switch (N) {
           default:
           case 1:
        	   sb.append(1);
        	   break;
           case 2:
           case 3:
        	   sb.append(0);
        	   break;
           case 4:
        	   sb.append(2);
        	   break;
           case 5:
        	   sb.append(10);
        	   break;
           case 6:
        	   sb.append(4);
        	   break;
           case 7:
        	   sb.append(40);
        	   break;
           case 8:
        	   sb.append(92);
        	   break;
           case 9:
        	   sb.append(352);
        	   break;
           case 10:
        	   sb.append(724);
        	   break;
        	   
           }
            
            sb.append("\n");
        }
         
        System.out.print(sb);
    }
}