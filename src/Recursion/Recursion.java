package Recursion;

import java.util.ArrayList;

public class Recursion {

	public static void main(String[] args) {

		int[] arr = { 3, 8, 1, 5, 8, 0 };
		// System.out.println(isSorted(arr, 0));
		// System.out.println(firstIndex(arr, 0, 8));

		// System.out.println(getSS("abc"));
		// printSS("abc", " ");
		System.out.println(getPermutation("abc"));

	}

	public static boolean isSorted(int[] arr, int si) {

		if (arr.length - 1 == si) {
			return true;
		}

		if (arr[si] > arr[si + 1]) {
			return false;
		} else {
			boolean ans = isSorted(arr, si + 1);
			return ans;
		}

	}

	public static int firstIndex(int[] arr, int si, int data) {

		if (si == arr.length) {
			return -1;
		}
		if (data == arr[si]) {

			return si;
		} else {
			int ans = firstIndex(arr, si + 1, data);
			return ans;
		}
	}

	public static int lastIndex(int[] arr, int si, int data) {

		if (si == arr.length) {
			return -1;
		}
		int index = lastIndex(arr, si + 1, data);
		if (index == -1) {
			if (data == arr[si]) {
				return si;
			} else {
				return -1;
			}
		} else {
			return index;
		}
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add(" ");
			return base;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getSS(ros);
		for (int i = 0; i < recResult.size(); i++) {
			myResult.add(recResult.get(i));
			myResult.add(cc + recResult.get(i));
		}

		return myResult;

	}

	public static void printSS(String str, String res) {

		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		printSS(ros, res);
		printSS(ros, res + cc);
	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add(" ");
			return base;

		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutation(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			for (int i = 0; i <= rrs.length(); i++) {
				String val = rrs.substring(0, i) + cc + rrs.substring(i);
				mr.add(val);
			}
		}
		return mr;
	}

	public static void printPermutation(String s, String result) {

		if (s.length() == 0) {
			System.out.println(result);
			return;
		}

		for (int i = 0; i < s.length(); i++) {

			char cc = s.charAt(i);
			String roq = s.substring(0, i) + s.substring(i + 1);
			printPermutation(roq, result + cc);
		}
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add(" ");
			return br;

		}
		if (curr > end) {
			ArrayList<String> brr = new ArrayList<>();
			return brr;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end);

			for (String rrs : rr) {
				mr.add(dice + rrs);
			}

		}
		return mr;
	}

	public static void printBoardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return;
		}
		if (curr > end) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			printBoardPath(curr + dice, end, ans + dice);
		}

	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> brr = new ArrayList<>();
			return brr;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);
		for (String rrhs : rrh) {
			mr.add("H" + rrhs);
		}

		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);
		for (String rrvs : rrv) {
			mr.add("V" + rrvs);
		}

		return mr;
	}

	public static void printMazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}

		printMazePath(cr, cc + 1, er, ec, ans + "H");
		printMazePath(cr + 1, cc, er, ec, ans + "V");

	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> brr = new ArrayList<>();
			return brr;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec);
		for (String rrhs : rrh) {
			mr.add("H" + rrhs);
		}

		ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec);
		for (String rrvs : rrv) {
			mr.add("V" + rrvs);
		}
		ArrayList<String> rrd = getMazePathD(cr + 1, cc + 1, er, ec);
		for (String rrds : rrd) {
			mr.add("D" + rrds);
		}

		return mr;
	}

	public static void printMazePathD(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}

		printMazePathD(cr, cc + 1, er, ec, ans + "H");
		printMazePathD(cr + 1, cc, er, ec, ans + "V");
		printMazePathD(cr + 1, cc + 1, er, ec, ans + "D");

	}

}
