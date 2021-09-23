package DynamicProgramming;

public class UniqueBSTLeetCode {

	public static void main(String[] args) {

		int n = 3;
		System.out.println(UniqueBSTrec(n));
		System.out.println(UniqueBSTtd(n,new int[n+1]));
		System.out.println(UniqueBSTBU(n));

	}

	public static int UniqueBSTrec(int n) {

		if (n <= 1)
			return 1;

		int total = 0;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int l = UniqueBSTrec(i - 1);
			int r = UniqueBSTrec(n - i);

			ans = l * r;
			total += ans;
		}

		return total;
	}

	public static int UniqueBSTtd(int n,int[] strg) {

		if (n <= 1)
			return 1;
		
		if(strg[n]!=0)
			return strg[n];

		int total = 0;
		
		for (int i = 1; i <= n; i++) {
			int l = UniqueBSTtd(i - 1,strg);
			int r = UniqueBSTtd(n - i,strg);

			int ans = l * r;
			total += ans;
		}
		strg[n]=total;
		return total;
	}
	public static int UniqueBSTBU(int tn) {
		
		int[] strg=new int[tn+1];
		
		strg[0]=1;
		strg[1]=1;
		
		for(int n=2;n<strg.length;n++) {
			
			int total=0;
			
			for (int i = 1; i <= n; i++) {
				int l = strg[i-1];
				int r = strg[n-i];

				int ans = l * r;
				total += ans;
			}
			strg[n]=total;
		
			
		}
		return strg[tn];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
