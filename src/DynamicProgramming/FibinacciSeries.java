package DynamicProgramming;

public class FibinacciSeries {

	public static void main(String[] args) {

		int n = 25;
		System.out.println(FibRecurssion(n));
		System.out.println(FibTD(n, new int[n + 1]));
		System.out.println(FibBU(n));
		System.out.println(FibBUspaceEfficient(n));

	}

//	Time complexity: O(2^n) 
	public static int FibRecurssion(int n) {

		if (n == 0 || n == 1)
			return n;

		int ans = 0;

		int fn1 = FibRecurssion(n - 1);
		int fn2 = FibRecurssion(n - 2);

		ans = fn1 + fn2;

		return ans;
	}

//	TC:O(n) SC:n + Rec Extra space
	public static int FibTD(int n, int[] strg) {

		if (n == 0 || n == 1)
			return n;

		if (strg[n] != 0)
			return strg[n];

		int fn1 = FibTD(n - 1, strg);
		int fn2 = FibTD(n - 2, strg);

		int ans = fn1 + fn2;

		strg[n] = ans;

		return ans;

	}

//	TC : n SC:n
	public static int FibBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];
	}

//	TC: n SC:O(1)
	public static int FibBUspaceEfficient(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}
		return strg[1];
	}

}
