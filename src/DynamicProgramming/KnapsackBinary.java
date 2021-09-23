package DynamicProgramming;

public class KnapsackBinary {

	public static void main(String[] args) {

		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
		int cap = 7;
		System.out.println(KSrec(wt, price, 0, cap));
		System.out.println(KSTD(wt, price, 0, cap, new int[wt.length][cap + 1]));
		System.out.println(KSBU(wt, price, cap));
	}

	public static int KSrec(int[] wt, int[] price, int vidx, int cap) {

		if (wt.length == vidx || cap == 0)
			return 0;

		int e = KSrec(wt, price, vidx + 1, cap);

		int i = 0;
		if (cap >= wt[vidx])
			i = KSrec(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];

		int ans = Math.max(e, i);
		return ans;
	}

	public static int KSTD(int[] wt, int[] price, int vidx, int cap, int[][] strg) {

		if (wt.length == vidx || cap == 0)
			return 0;

		if (strg[vidx][cap] != 0)
			return strg[vidx][cap];

		int e = KSTD(wt, price, vidx + 1, cap, strg);

		int i = 0;
		if (cap >= wt[vidx])
			i = KSTD(wt, price, vidx + 1, cap - wt[vidx], strg) + price[vidx];

		int ans = Math.max(e, i);

		strg[vidx][cap] = ans;
		return ans;
	}

	public static int KSBU(int[] wt, int[] price, int cap) {

		int n = wt.length;
		int[][] strg = new int[n + 1][cap + 1];

		for (int row = n - 1; row >= 0; row--) {
			for (int col = 1; col <= cap; col++) {

				int e = strg[row + 1][col];

				int i = 0;
				if (col >= wt[row])
					i = strg[row + 1][col - wt[row]] + price[row];

				strg[row][col] = Math.max(e, i);

			}
		}

		return strg[0][cap];
	}

}
