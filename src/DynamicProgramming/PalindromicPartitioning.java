package DynamicProgramming;

import java.util.Arrays;

public class PalindromicPartitioning {

	public static void main(String[] args) {

		String s = "abacbcd";
		System.out.println(PPrec(s, 0, s.length() - 1));

		int[][] strg = new int[s.length() + 1][s.length() + 1];

		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}
		System.out.println(PPTD(s, 0, s.length() - 1, strg));
		System.out.println(PPBU(s));

	}

	public static int PPrec(String s, int si, int ei) {

		if (isPalindrome(s, si, ei))
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {
			int fp = PPrec(s, si, k);
			int sp = PPrec(s, k + 1, ei);

			int total = fp + sp + 1;

			if (total < min)
				min = total;
		}
		return min;
	}

	public static boolean isPalindrome(String s, int si, int ei) {

		int l = si;
		int r = ei;

		while (l < r) {

			if (s.charAt(l) != s.charAt(r))
				return false;

			l++;
			r--;
		}
		return true;
	}

	public static int PPTD(String s, int si, int ei, int[][] strg) {

		if (isPalindrome(s, si, ei))
			return 0;
		if (strg[si][ei] != -1)
			return strg[si][ei];

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {
			int fp = PPTD(s, si, k, strg);
			int sp = PPTD(s, k + 1, ei, strg);

			int total = fp + sp + 1;

			if (total < min)
				min = total;
		}
		strg[si][ei] = min;
		return min;
	}

	public static int PPBU(String s) {

		int[][] strg = new int[s.length()][s.length()];

		for (int slide = 0; slide <= s.length() - 1; slide++) {
			
			for (int si = 0; si <=s.length() - slide - 1; si++) {
				
				int ei = si + slide;

				if (isPalindrome(s, si, ei)) {
					strg[si][ei] = 0;
				}else {

					int min = Integer.MAX_VALUE;

					for (int k = si; k <= ei - 1; k++) {
						int fp = strg[si][k];
						int sp = strg[k + 1][ei];

						int total = fp + sp + 1;

						if (total < min)
							min = total;
					}
					strg[si][ei] = min;

				}
			}

		}

		return strg[0][s.length() - 1];
	}

}