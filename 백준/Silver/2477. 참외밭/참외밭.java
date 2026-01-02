import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cnt = new int[4 + 1];
		Node[] nodes = new Node[6];
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			cnt[direction]++;
			nodes[i] = new Node(direction, length);
		}
		
		int bigX = 0;
		int bigY = 0;
		int smallX = 0;
		int smallY = 0;
		boolean findSmallXY = false;
		
		// case 1
		if (cnt[1] == 2 && cnt[2] == 1 && cnt[3] == 2 && cnt[4] == 1) {
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].direction == 2) {
					bigX = nodes[i].length;
				}
				
				if (nodes[i].direction == 4) {
					bigY = nodes[i].length;
				}
				
				if (i < 5 && nodes[i].direction == 1 && nodes[i + 1].direction == 3) {
					smallX = nodes[i].length;
					smallY = nodes[i+1].length;
					findSmallXY = true;
				}
			}
			
			if (!findSmallXY) {
				smallX = nodes[0].length;
				smallY = nodes[5].length;
			}
		}
		
		// case 2
		if (cnt[1] == 1 && cnt[2] == 2 && cnt[3] == 2 && cnt[4] == 1) {
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].direction == 1) {
					bigX = nodes[i].length;
				}
				
				if (nodes[i].direction == 4) {
					bigY = nodes[i].length;
				}
				
				if (i < 5 && nodes[i].direction == 3 && nodes[i + 1].direction == 2) {
					smallX = nodes[i].length;
					smallY = nodes[i+1].length;
					findSmallXY = true;
				}
			}
			
			if (!findSmallXY) {
				smallX = nodes[0].length;
				smallY = nodes[5].length;
			}
		}
		
		// case 3
		if (cnt[1] == 1 && cnt[2] == 2 && cnt[3] == 1 && cnt[4] == 2) {
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].direction == 3) {
					bigX = nodes[i].length;
				}
				
				if (nodes[i].direction == 1) {
					bigY = nodes[i].length;
				}
				
				if (i < 5 && nodes[i].direction == 2 && nodes[i + 1].direction == 4) {
					smallX = nodes[i].length;
					smallY = nodes[i+1].length;
					findSmallXY = true;
				}
			}
			
			if (!findSmallXY) {
				smallX = nodes[0].length;
				smallY = nodes[5].length;
			}
		}
		
		// case 4
		if (cnt[1] == 2 && cnt[2] == 1 && cnt[3] == 1 && cnt[4] == 2) {
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i].direction == 2) {
					bigX = nodes[i].length;
				}
				
				if (nodes[i].direction == 3) {
					bigY = nodes[i].length;
				}
				
				if (i < 5 && nodes[i].direction == 4 && nodes[i + 1].direction == 1) {
					smallX = nodes[i].length;
					smallY = nodes[i+1].length;
					findSmallXY = true;
				}
			}
			
			if (!findSmallXY) {
				smallX = nodes[0].length;
				smallY = nodes[5].length;
			}
		}
		
		int result = (bigX * bigY - smallX * smallY) * N;
		
		System.out.println(result);
	}
	
	static class Node {
		int direction;
		int length;
		
		Node(int direction, int length) {
			this.direction = direction;
			this.length = length;
		}
	}
}