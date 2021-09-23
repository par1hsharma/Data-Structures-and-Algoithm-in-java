package DynamicProgramming;

public class MatrixChainMultiplication {

	public static void main(String[] args) {

		int[] arr = { 4, 2, 3, 5, 1 };
		System.out.println(MCMrec(arr, 0, arr.length - 1));
		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MCMBU(arr));

	}

	public static int MCMrec(int[] arr, int si, int ei) {

		if (si + 1 == ei)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {
			int fp = MCMrec(arr, si, k);
			int sp = MCMrec(arr, k, ei);

			int sw = arr[si] * arr[k] * arr[ei];
			int total = sw + fp + sp;

			if (total < min) {
				min = total;
			}

		}
		return min;
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei)
			return 0;

		if (strg[si][ei] != 0)
			return strg[si][ei];

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {
			int fp = MCMTD(arr, si, k, strg);
			int sp = MCMTD(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];
			int total = sw + fp + sp;

			if (total < min) {
				min = total;
			}

		}
		strg[si][ei] = min;
		return min;
	}

	public static int MCMBU(int[] arr) {

		int[][] strg = new int[arr.length][arr.length];

		for (int slide = 1; slide <= arr.length; slide++) {
			for (int si = 0; si <= arr.length - slide - 1; si++) {

				int ei = si + slide;

				if (si + 1 == ei) {
					strg[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = si + 1; k <= ei - 1; k++) {
						int fp = strg[si][k];
						int sp = strg[k][ei];

						int sw = arr[si] * arr[k] * arr[ei];
						int total = sw + fp + sp;

						if (total < min) {
							min = total;
						}

					}
					strg[si][ei] = min;

				}
			}

		}
		return strg[0][arr.length-1];

	}

}
