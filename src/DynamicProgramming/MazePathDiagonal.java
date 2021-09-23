package DynamicProgramming;

import java.util.Arrays;

public class MazePathDiagonal {

	public static void main(String[] args) {

		int er = 2;
		int ec = 2;
		int cr = 0;
		int cc = 0;
		System.out.println(MPDrec(cr, cc, er, ec));
		System.out.println(MPDTD(cr, cc, er, ec, new int[er + 1][ec + 1]));
		System.out.println(MPDBU(er, ec));
		System.out.println(MPBUSE(er, ec));

	}

	public static int MPDrec(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}

		int h = MPDrec(cr, cc + 1, er, ec);
		int v = MPDrec(cr + 1, cc, er, ec);
		int d = MPDrec(cr + 1, cc + 1, er, ec);

		return h + v + d;
	}

	public static int MPDTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}
		if (strg[cr][cc] != 0)
			return strg[cr][cc];

		int h = MPDTD(cr, cc + 1, er, ec, strg);
		int v = MPDTD(cr + 1, cc, er, ec, strg);
		int d = MPDTD(cr + 1, cc + 1, er, ec, strg);

		strg[cr][cc] = h + v + d;
		return h + v + d;
	}

	public static int MPDBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1] + strg[row + 1][col + 1];
				}
			}
		}
		return strg[0][0];

	}

	public static int MPBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);
		int diag=0;

		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
					diag=1;
				} else {
					int val = strg[col] + strg[col + 1]+diag;
					diag=strg[col];
					strg[col]=val;
				}
			}
		}
		return strg[0];
	}

}
