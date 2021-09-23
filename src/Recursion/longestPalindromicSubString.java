package Recursion;

public class longestPalindromicSubString {

	public static void main(String[] args) {
		
		String s="abcba";
		//System.out.println(longestSSTD(s, 0,s.length()-1,new String[s.length()][s.length()]));
		System.out.println(longestSS(s, 0, s.length()-1));

	}
	public static String longestSS(String s,int si,int ei) {
		
		if(si>ei) {
			return " ";
		}
		if(si==ei) {
			return String.valueOf(s.charAt(si));
		}
		
		if(s.charAt(si)==s.charAt(ei)) {
			String both=longestSS(s, si+1, ei-1);
			if(both.length()==ei-si-1) 
					return s.charAt(si)+both+s.charAt(ei);
			
		}
		
			String o1=longestSS(s, si+1, ei);
			String o2=longestSS(s, si, ei-1);
			
			if(o1.length()>o2.length()) 
				return o1;
			
			else 
				return o2;
			
			
		}
		
public static String longestSSTD(String s,int si,int ei,String[][] strg) {
		
		if(si>ei) {
			return " ";
		}
		if(si==ei) {
			return String.valueOf(s.charAt(si));
		}
		if(strg[si][ei]!="0") {
			return strg[si][ei];
		}
		String ans="\0";
		if(s.charAt(si)==s.charAt(ei)) {
			String both=longestSSTD(s, si+1, ei-1,strg);
			if(both.length()==ei-si-1) 
				 ans= s.charAt(si)+both+s.charAt(ei);
			
		}
		
			String o1=longestSSTD(s, si+1, ei,strg);
			String o2=longestSSTD(s, si, ei-1,strg);
			
			if(o1.length()>o2.length()) 
				ans= o1;
			
			else 
				ans= o2;
			
			strg[si][ei]=ans;
			return ans;
		}

}
