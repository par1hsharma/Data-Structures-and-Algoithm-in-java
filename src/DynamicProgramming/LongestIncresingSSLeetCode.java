package DynamicProgramming;

import java.util.Arrays;

public class LongestIncresingSSLeetCode {

	public static void main(String[] args) {
		
		int[] arr= {3,4,-1,0,6,2,3};
		System.out.println(LIS(arr));

	}
// TC: n^2
	public static int LIS(int[] arr) {
		
		if(arr.length==0)
			return 0;
		
		int[] strg=new int[arr.length];
		int max=1;
		
		Arrays.fill(strg, 1);
		
		for(int i=0;i<strg.length;i++) {
			
			for(int j=0;j<i;j++) {
				
				if(arr[j]<arr[i]) {
					strg[i]=Math.max(strg[j], strg[j]+1);
					
					max=Math.max(max, strg[i]);
				}
			}
		}
		return max;
	}
}
