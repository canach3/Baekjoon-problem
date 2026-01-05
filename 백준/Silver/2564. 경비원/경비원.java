import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][2];
		
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int NSEW = Integer.parseInt(st.nextToken());
			
			if (NSEW == 1) {
				int x = Integer.parseInt(st.nextToken());
				map[i][0] = x;
				map[i][1] = height;
			}
			
			if (NSEW == 2) {
				int x = Integer.parseInt(st.nextToken());
				map[i][0] = x;
				map[i][1] = 0;		
			}
			
			if (NSEW == 3) {
				int y = Integer.parseInt(st.nextToken());
				map[i][0] = 0;
				map[i][1] = height - y;
			}
			
			if (NSEW == 4) {
				int y = Integer.parseInt(st.nextToken());
				map[i][0] = width;
				map[i][1] = height - y;
			}
		}
		
		int myX = map[N][0];
		int myY = map[N][1];
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 같은 선상
			if ((myX == 0 && map[i][0] == 0) || (myX == width && map[i][0] == width) ||
				(myY == 0 && map[i][1] == 0) || (myY == height && map[i][1] == height)) {
				sum += Math.max(myX, map[i][0]) - Math.min(myX, map[i][0]);
				sum += Math.max(myY, map[i][1]) - Math.min(myY, map[i][1]);
			}
			
			// ㄴ 자
			if (((myY == 0 || myY == height) && (map[i][1] > 0 && map[i][1] < height)) ||
				((myX == 0 || myX == width) && (map[i][0] > 0 && map[i][0] < width))) {
				int lengthX = Math.max(myX, map[i][0]) - Math.min(myX, map[i][0]);
				int lengthY = Math.max(myY, map[i][1]) - Math.min(myY, map[i][1]);
				sum += lengthX + lengthY;
			}
			
			// 마주보는 상황
			if ((myY == 0 && map[i][1] == height) || (myY == height && map[i][1] == 0)) {
				int lengthX = Math.min(myX + map[i][0], width - myX + width - map[i][0]);
				int lengthY = height;
				sum += lengthX + lengthY;
			}
			
			if ((myX == 0 && map[i][0] == width) || (myX == width && map[i][0] == 0)) {
				int lengthX = width;
				int lengthY = Math.min(myY + map[i][1], height - myY + height - map[i][1]);
				sum += lengthX + lengthY;
			}
		}
		
		System.out.println(sum);
	}
}