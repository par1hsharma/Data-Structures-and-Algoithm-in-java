package DynamicProgramming;

public class RodCut {

	public static void main(String[] args) {

		int[] price = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = 8;
		System.out.println(RodCutRec(price, n));
		System.out.println(RodCutTD(price, n, new int[price.length]));
		System.out.println(RodCutBU(price));

	}

	public static int RodCutRec(int[] price, int n) {

		int left = 1;
		int right = n - 1;
		int max = price[n];

		while (left < right) {
			int fp = RodCutRec(price, left);
			int sp = RodCutRec(price, right);

			int total = fp + sp;

			if (total > max)
				max = total;

			left++;
			right--;

		}
		return max;
	}

	public static int RodCutTD(int[] price, int n, int[] strg) {

		if (strg[n] != 0)
			return strg[n];

		int left = 1;
		int right = n - 1;
		int max = price[n];

		while (left < right) {
			int fp = RodCutRec(price, left);
			int sp = RodCutRec(price, right);

			int total = fp + sp;

			if (total > max)
				max = total;

			left++;
			right--;

		}
		strg[n] = max;
		return max;
	}

	public static int RodCutBU(int[] price) {

		int[] strg = new int[price.length];

		strg[0] = price[0];
		strg[1] = price[1];

		for (int n = 2; n < strg.length; n++) {

			int left = 1;
			int right = n - 1;
			int max = price[n];

			while (left < right) {
				int fp = strg[left];
				int sp = strg[right];

				int total = fp + sp;

				if (total > max)
					max = total;

				left++;
				right--;

			}
			strg[n] = max;
		}
		return strg[price.length - 1];

	}

}
