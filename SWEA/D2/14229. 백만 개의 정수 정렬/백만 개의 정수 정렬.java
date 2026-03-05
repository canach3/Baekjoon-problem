import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr;
    static int[] tmp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[1000000];
		tmp = new int[1000000];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, 1000000 - 1);
		
		System.out.println(arr[500000]);
	}	
	
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;	
			
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			
			merge(left, mid, right);
		}
	}
	
    static void merge(int left, int mid, int right) {
    	int i = left;
    	int j = mid + 1;
    	int idx = left;
    	
    	while (i <= mid && j <= right) {
    		if (arr[i] <= arr[j]) {
    			tmp[idx++] = arr[i++];
    		} else {
    			tmp[idx++] = arr[j++];
    		}
    	}
    	
    	while (i <= mid) {
    		tmp[idx++] = arr[i++];
    	}
    	
    	while (j <= right) {
    		tmp[idx++] = arr[j++];
    	}
    	
    	for (int k = left; k <= right; k++) {
			arr[k] = tmp[k];
		}
    }
}