package DynamicProgramming;

public class WineProblem {

	public static void main(String[] args) {

		int[] arr = { 2, 3, 5, 1, 4 };
		System.out.println(WPrec(arr, 0, arr.length - 1, 1));
		System.out.println(WPTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(WPBU(arr));
		System.out.println(WPBU2(arr));

	}

	public static int WPrec(int[] arr, int si, int ei, int year) {

		if (si == ei)
			return arr[si] * year;

		int start = WPrec(arr, si + 1, ei, year + 1) + arr[si] * year;
		int end = WPrec(arr, si, ei - 1, year + 1) + arr[ei] * year;

		int ans = Math.max(start, end);
		return ans;
	}

	public static int WPTD(int[] arr, int si, int ei, int[][] strg) {

		int year = arr.length - (ei - si + 1) + 1;
		if (si == ei)
			return arr[si] * year;

		if (strg[si][ei] != 0)
			return strg[si][ei];

		int start = WPTD(arr, si + 1, ei, strg) + arr[si] * year;
		int end = WPTD(arr, si, ei - 1, strg) + arr[ei] * year;

		int ans = Math.max(start, end);

		strg[si][ei] = ans;
		return ans;
	}
//filling array diaglonally
	public static int WPBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				int year = arr.length - (ei - si + 1) + 1;
				if (si == ei) {
					strg[si][ei] = arr[si] * year;
				} else {

					int start = strg[si + 1][ei] + arr[si] * year;
					int end = strg[si][ei - 1] + arr[ei] * year;

					strg[si][ei] = Math.max(start, end);
				}

			}
		}
		return strg[0][4];
	}
//	filling array form last row first col
	public static int WPBU2(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for(int si=n-1;si>=0;si--) {
			for(int ei=0;ei<n;ei++) {

				int year = arr.length - (ei - si + 1) + 1;
				if(si>ei) {
					strg[si][ei]=0;
				}
				else if (si == ei) {
					strg[si][ei] = arr[si] * year;
				} else {

					int start = strg[si + 1][ei] + arr[si] * year;
					int end = strg[si][ei - 1] + arr[ei] * year;

					strg[si][ei] = Math.max(start, end);
				}

			}
		}
		return strg[0][4];
	}

}
