package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "abcd";

		int[][] strg = new int[s1.length()][s2.length()];

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				strg[i][j] = -1;
			}
		}

		System.out.println(LCSrec(s1, s2));
		System.out.println(LCSrecVIDX(s1, s2, 0, 0));
		System.out.println(LCStd(s1, s2, 0, 0, strg));
		System.out.println(LCSBU(s1, s2));
		PrintLCS(s1, s2);

	}

	public static int LCSrecVIDX(String s1, String s2, int vidx1, int vidx2) {

		if (s1.length() == vidx1 || s2.length() == vidx2)
			return 0;

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCSrecVIDX(s1, s2, vidx1 + 1, vidx2 + 1) + 1;
		} else {
			int o1 = LCSrecVIDX(s1, s2, vidx1, vidx2 + 1);
			int o2 = LCSrecVIDX(s1, s2, vidx1 + 1, vidx2);

			ans = Math.max(o1, o2);
		}
		return ans;
	}

	public static int LCSrec(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCSrec(ros1, ros2) + 1;
		} else {
			int o1 = LCSrec(s1, ros2);
			int o2 = LCSrec(ros1, s2);

			ans = Math.max(o1, o2);
		}
		return ans;
	}

	public static int LCStd(String s1, String s2, int vidx1, int vidx2, int[][] strg) {

		if (s1.length() == vidx1 || s2.length() == vidx2)
			return 0;

		if (strg[vidx1][vidx2] != -1)
			return strg[vidx1][vidx2];

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCStd(s1, s2, vidx1 + 1, vidx2 + 1, strg) + 1;
		} else {
			int o1 = LCStd(s1, s2, vidx1, vidx2 + 1, strg);
			int o2 = LCStd(s1, s2, vidx1 + 1, vidx2, strg);

			ans = Math.max(o1, o2);
		}
		strg[vidx1][vidx2] = ans;
		return ans;
	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					int o1 = strg[row + 1][col];
					int o2 = strg[row][col + 1];

					strg[row][col] = Math.max(o1, o2);
				}
			}
		}

		for (int row = 0; row < strg.length; row++) {
			for (int col = 0; col < strg.length; col++) {
				System.out.print(strg[row][col] + " ");
			}
			System.out.println();
		}
		return strg[0][0];
	}
	
	public static void PrintLCS(String s1,String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					int a = strg[row + 1][col];
					int b = strg[row][col + 1];
					strg[row][col] = Math.max(a, b);

				}

			}
		}
		String ans = "";

		int row = 0;
		int col = 0;

		while (row < s1.length() && col < s2.length()) {

			if (strg[row][col] == strg[row + 1][col]) {
				row++;
			} else if (strg[row][col] == strg[row][col + 1]) {
				col++;
			} else {
				ans = ans + s1.charAt(row);
				row++;
				col++;

			}

		}
		System.out.println(ans);
//		return strg[0][0];
	}

}
