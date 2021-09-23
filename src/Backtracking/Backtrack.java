package Backtracking;

public class Backtrack {

	static int count = 0;

	public static void main(String[] args) {

		QueenPermutation(new boolean[4], 2, 0, " ");
		// QueenCombination(new boolean[4], 2, 0," ", -1);
		// CoinCombination(new int[] {2,3,5,6},10, " ", 0);
		// CoinPermutation(new int[] { 2, 3, 5, 6 }, 10, " ");
		// QueenCombinationBoxRespect(new boolean[4], 0,0, 2, " ");
		// CoinChangeCoinRespect(new int[] {2, 3, 5, 6},0,10,"");
		// QueenCombination2D(new boolean[2][2], 0,0,0, 2,"");
		// QueenCombination2DKill(new boolean[3][4], 0, 0, 0, 3, "");

		// boolean[][] board = new boolean[4][4];
		// NQueen(board, 0, 0, 0, board.length, " ");

		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		//BlockedMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
	}

//	tq=total queens  qpsf=queen placed so faar
	public static void QueenPermutation(boolean[] box, int tq, int qpsf, String ans) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + "." + ans);
			return;
		}

		for (int i = 0; i < box.length; i++) {

			if (box[i] == false) {
				box[i] = true;

				QueenPermutation(box, tq, qpsf + 1, ans + "q" + qpsf + "b" + i + " ");
				box[i] = false;
			}
		}
	}

	public static void QueenCombination(boolean[] box, int tq, int qpsf, String ans, int lastboxused) {

		if (qpsf == tq) {
			count++;
			System.out.println(count + "." + ans);
			return;
		}

		for (int i = lastboxused + 1; i < box.length; i++) {

			box[i] = true;

			QueenCombination(box, tq, qpsf + 1, ans + "q" + qpsf + "b" + i + " ", i);
			box[i] = false;

		}
	}

	public static void CoinCombination(int[] deno, int amount, String ans, int lastindexUsed) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0)
			return;

		for (int i = lastindexUsed; i < deno.length; i++) {

			CoinCombination(deno, amount - deno[i], ans + deno[i], i);
		}
	}

	public static void CoinPermutation(int[] deno, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0) {
			return;
		}

		for (int i = 0; i < deno.length; i++) {

			CoinPermutation(deno, amount - deno[i], ans + deno[i]);
		}

	}

	public static void QueenCombinationBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == board.length)
			return;

		board[col] = true;
		QueenCombinationBoxRespect(board, col + 1, qpsf + 1, tq, ans + "b" + col + " ");
		board[col] = false;

		QueenCombinationBoxRespect(board, col + 1, qpsf, tq, ans);
	}

	public static void CoinChangeCoinRespect(int[] deno, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0 || vidx == deno.length)
			return;

		CoinChangeCoinRespect(deno, vidx, amount - deno[vidx], ans + deno[vidx]);
		CoinChangeCoinRespect(deno, vidx + 1, amount, ans);
	}

	public static void QueenCombination2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length)
			return;

		board[row][col] = true;
		QueenCombination2D(board, row, col + 1, qpsf + 1, tq, ans + row + "-" + col + " ");
		board[row][col] = false;

		QueenCombination2D(board, row, col + 1, qpsf, tq, ans);

	}

	public static void QueenCombination2DKill(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length)
			return;

		if (isItSafeToPlaceQueen(board, row, col)) {
			board[row][col] = true;
			QueenCombination2DKill(board, row, col + 1, qpsf + 1, tq, ans + row + "-" + col + " ");
			board[row][col] = false;
		}
		QueenCombination2DKill(board, row, col + 1, qpsf, tq, ans);
	}

	private static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {

//		vertically
		int r = row - 1;
		int c = col;
		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}
//		horizontally
		r = row;
		c = col - 1;
		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}
			c--;
		}

//		diagonally left
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c--;
		}

//		diagonally right
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
		}

		return true;

	}

	public static void NQueen(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length)
			return;

		if (isItSafeToPlaceQueen(board, row, col)) {
			board[row][col] = true;
			NQueen(board, row + 1, 0, qpsf + 1, tq, ans + row + "-" + col + " ");// make a call to the next row because
																					// we know queen will be killed in
																					// the same row
			board[row][col] = false;
		}
		NQueen(board, row, col + 1, qpsf, tq, ans);
	}

	public static void Nknight(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {

		if (kpsf == tk) {
			System.out.println(ans);
			return;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length)
			return;

		if (isItSafeToPlaceKnight(board, row, col)) {

			board[row][col] = true;
			Nknight(board, row, col + 1, kpsf + 1, tk, ans + row + "-" + col + " ");
			board[row][col] = false;
		}

		Nknight(board, row, col + 1, kpsf, tk, ans);

	}

	private static boolean isItSafeToPlaceKnight(boolean[][] board, int row, int col) {

		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { 2, 1, -1, -2 };

		for (int i = 0; i < 4; i++) {
			int r = row + rowArr[i];
			int c = col + colArr[i];

			if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
				if (board[r][c])
					return false;
			}
		}
		return true;
	}

	public static void NQueen2(boolean[][] board, int row, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (row == board.length)
			return;

		for (int col = 0; col < board[0].length; col++) {

			board[row][col] = true;
			NQueen2(board, row + 1, qpsf + 1, tq, ans + row + "." + col + " ");
			board[row][col] = false;
		}

	}

	public static void BlockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}
		if (row == -1 || col == maze[0].length || col == -1 || row == maze.length || maze[row][col] == 1
				|| visited[row][col]) {
			return;
		}
		visited[row][col] = true;
		BlockedMaze(maze, row - 1, col, ans + "T", visited);
		BlockedMaze(maze, row + 1, col, ans + "D", visited);
		BlockedMaze(maze, row, col - 1, ans + "L", visited);
		BlockedMaze(maze, row, col + 1, ans + "R", visited);
		visited[row][col] = false;
	}

}
