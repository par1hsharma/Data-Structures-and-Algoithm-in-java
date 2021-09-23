package DynamicProgramming;

public class LongestPalindromicSS {
//Subsequence
	public static void main(String[] args) {

		String s = "aba";
		System.out.println(LongestPalindromicSSrec(s, 0, s.length() - 1));
		System.out.println(LongestPalindromicSStd(s, 0, s.length() - 1, new int[s.length()][s.length()]));
		System.out.println(LongestPalindromicBU(s));
	}

	public static int LongestPalindromicSSrec(String s, int si, int ei) {

		if (si > ei)
			return 0;
		if (si == ei)
			return 1;
		int ans = 0;
		if (s.charAt(si) == s.charAt(ei)) {
			ans = LongestPalindromicSSrec(s, si + 1, ei - 1) + 2;
		} else {
			int fp = LongestPalindromicSSrec(s, si + 1, ei);
			int sp = LongestPalindromicSSrec(s, si, ei - 1);

			ans = Math.max(fp, sp);

		}
		return ans;
	}

	public static int LongestPalindromicSStd(String s, int si, int ei, int[][] strg) {

		if (si > ei)
			return 0;
		if (si == ei)
			return 1;

		if (strg[si][ei] != 0)
			return strg[si][ei];

		int ans = 0;
		if (s.charAt(si) == s.charAt(ei)) {
			ans = LongestPalindromicSStd(s, si + 1, ei - 1, strg) + 2;
		} else {
			int fp = LongestPalindromicSStd(s, si + 1, ei, strg);
			int sp = LongestPalindromicSStd(s, si, ei - 1, strg);

			ans = Math.max(fp, sp);

		}
		strg[si][ei] = ans;
		return ans;
	}
	
	public static int LongestPalindromicBU(String s) {
		
		int n=s.length();
		int[][] strg=new int[n][n];
		
		for(int slide=0;slide<=n;slide++) {
			for(int si=0;si<=n-slide-1;si++) {
				int ei=si+slide;
				
				if (si == ei) {
					strg[si][ei]=1;
				}else {
				int ans = 0;
				if (s.charAt(si) == s.charAt(ei)) {
					ans = strg[si+1][ei-1] + 2;
				} else {
					int fp = strg[si+1][ei];
					int sp = strg[si][ei-1];

					ans = Math.max(fp, sp);

				}
				strg[si][ei] = ans;
			
				
				}
			}
		}
		return strg[0][n-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
