package DynamicProgramming;

public class WildCardPatternMatching {

	public static void main(String[] args) {

		String src = "abacd";
		String pat = "?*?c**";

		System.out.println(WPMrec(src, pat));
		System.out.println(WPMrec(src, pat, 0, 0));
		System.out.println(WPMTD(src, pat, 0,0,new int[src.length()][pat.length()]));
		System.out.println(WPMBU(src, pat));

	}

	public static boolean WPMrec(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0)
			return false;
		if (src.length() != 0 && pattern.length() == 0)
			return false;
		if (src.length() == 0 && pattern.length() != 0) {

			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*')
					return false;
			}
			return true;
		}

		char chs = src.charAt(0);
		char chp = pattern.charAt(0);

		String ros = src.substring(1);
		String rop = pattern.substring(1);

		boolean ans;

		if (chs == chp || chp == '?') {
			ans = WPMrec(ros, rop);
		} else if (chp == '*') {
			boolean blank = WPMrec(src, rop);
			boolean multiple = WPMrec(ros, pattern);

			ans = blank || multiple;
		} else {
			ans = false;
		}
		return ans;

	}

	public static boolean WPMrec(String src, String pattern, int svidx, int pvidx) {

		if (src.length() == svidx && pattern.length() == pvidx)
			return false;
		if (src.length() != svidx && pattern.length() == pvidx)
			return false;
		if (src.length() == svidx && pattern.length() != pvidx) {

			for (int i = pvidx; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*')
					return false;
			}
			return true;
		}

		char chs = src.charAt(svidx);
		char chp = pattern.charAt(pvidx);

		boolean ans;

		if (chs == chp || chp == '?') {
			ans = WPMrec(src, pattern, svidx + 1, pvidx + 1);
		} else if (chp == '*') {
			boolean blank = WPMrec(src, pattern, svidx, pvidx + 1);
			boolean multiple = WPMrec(src, pattern, svidx + 1, pvidx);

			ans = blank || multiple;
		} else {
			ans = false;
		}
		return ans;

	}

	public static boolean WPMTD(String src, String pattern, int svidx, int pvidx, int[][] strg) {

		if (src.length() == svidx && pattern.length() == pvidx)
			return false;
		if (src.length() != svidx && pattern.length() == pvidx)
			return false;
		if (src.length() == svidx && pattern.length() != pvidx) {

			for (int i = pvidx; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*')
					return false;
			}
			return true;
		}

		if (strg[svidx][pvidx] != 0)
			return (strg[svidx][pvidx] == 2 ? true : false);

		char chs = src.charAt(svidx);
		char chp = pattern.charAt(pvidx);

		boolean ans;

		if (chs == chp || chp == '?') {
			ans = WPMTD(src, pattern, svidx + 1, pvidx + 1, strg);
		} else if (chp == '*') {
			boolean blank = WPMTD(src, pattern, svidx, pvidx + 1, strg);
			boolean multiple = WPMTD(src, pattern, svidx + 1, pvidx, strg);

			ans = blank || multiple;
		} else {
			ans = false;
		}
		strg[svidx][pvidx] = (ans == true ? 2 : 1);
		return ans;

	}
	public static boolean WPMBU(String src,String pat) {
		
		boolean[][] strg=new boolean[src.length()+1][pat.length()+1];
	
		
		strg[src.length()][pat.length()]=true;
		
		for(int row=src.length();row>=0;row--) {
			for(int col=pat.length()-1;col>=0;col--) {
				
				if(row==src.length()) {
					if(pat.charAt(col)=='*') {
						strg[row][col]=strg[row][col+1];
					}
					else {
						strg[row][col]=false;
					}
					continue;
				}
				char chs = src.charAt(row);
				char chp = pat.charAt(col);

				boolean ans;

				if (chs == chp || chp == '?') {
					ans = strg[row+1][col+1];
				} else if (chp == '*') {
					boolean blank = strg[row][col+1];
					boolean multiple =strg[row+1][col];

					ans = blank || multiple;
				} else {
					ans = false;
				}
				strg[row][col]=ans;
				

			}
		}
		return strg[0][0];
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
