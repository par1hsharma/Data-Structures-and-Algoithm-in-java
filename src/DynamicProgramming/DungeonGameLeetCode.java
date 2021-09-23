package DynamicProgramming;

public class DungeonGameLeetCode {

	public static void main(String[] args) {

		int[][] arr = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		System.out.println(DungeonGameRec(arr, 0, 0, arr.length - 1, arr[0].length - 1));
		System.out.println(
				DungeonGameTD(arr, 0, 0, arr.length - 1, arr[0].length - 1, new int[arr.length + 1][arr.length + 1]));
		System.out.println(DungeonGameBU(arr));
	}

	public static int DungeonGameRec(int[][] arr, int cr, int cc, int er, int ec) {

		if (cr == er && cc == er)
			return arr[cr][cc] <= 0 ? -arr[cr][cc] + 1 : 1;
		if (cr > er || cc > ec)
			return Integer.MAX_VALUE;

		int ans = 0;
		int r = DungeonGameRec(arr, cr, cc + 1, er, ec);
		int d = DungeonGameRec(arr, cr + 1, cc, er, ec);

		int path = Math.min(r, d);
		int AmountAlreadyhave = path - arr[cr][cc];

		if (AmountAlreadyhave < 1) {
			ans = 1;
		} else {
			ans = AmountAlreadyhave;
		}
		return ans;
	}

	public static int DungeonGameTD(int[][] arr, int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == er)
			return arr[cr][cc] <= 0 ? -arr[cr][cc] + 1 : 1;

		if (cr > er || cc > ec)
			return Integer.MAX_VALUE;
		if (strg[cr][cc] != 0)
			return strg[cr][cc];

		int ans = 0;
		int r = DungeonGameTD(arr, cr, cc + 1, er, ec, strg);
		int d = DungeonGameTD(arr, cr + 1, cc, er, ec, strg);

		int path = Math.min(r, d);
		int AmountAlreadyhave = path - arr[cr][cc];

		if (AmountAlreadyhave < 1) {
			ans = 1;
		} else {
			ans = AmountAlreadyhave;
		}
		strg[cr][cc] = ans;
		return ans;
	}

	public static int DungeonGameBU(int[][] arr) {

		int[][] strg = new int[arr.length + 1][arr[0].length + 1];

		for (int row = strg.length - 1; row >= 0; row--) {
			for (int col = strg.length - 1; col >= 0; col--) {

				if (row == strg.length - 2 && col == strg[0].length - 2) {
					strg[row][col] = arr[row][col] <= 0 ? -arr[row][col] + 1 : 1;

				} else if (row == strg.length - 1 || col == strg[0].length - 1) {
					strg[row][col] = Integer.MAX_VALUE;

				} else {

					int ans = 0;
					int r = strg[row][col + 1];
					int d = strg[row + 1][col];

					int path = Math.min(r, d);
					int AmountAlreadyhave = path - arr[row][col];

					if (AmountAlreadyhave < 1) {
						ans = 1;
					} else {
						ans = AmountAlreadyhave;
					}
					strg[row][col] = ans;

				}
			}
		}

		return strg[0][0];

	}
}
