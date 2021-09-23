package DynamicProgramming;

import java.util.Arrays;

public class MazePath {

	public static void main(String[] args) {
		
		int er=2;
		int ec=2;
		System.out.println(MPrec(0, 0, er,ec));
		System.out.println(MPTD(0, 0, er, ec, new int[er+1][ec+1]));
		System.out.println(MPBU(er, ec));
		System.out.println(MPBUSE(er, ec));
		

	}
	public static int MPrec(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}

		int h=MPrec(cr, cc + 1, er, ec);
		int v=MPrec(cr + 1, cc, er, ec);
		
		return h+v;
	}
//	TC:er+1 * ec+1 
	public static int MPTD(int cr, int cc, int er, int ec,int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}
		if(strg[cr][cc]!=0)
			return strg[cr][cc];

		int h=MPTD(cr, cc + 1, er, ec,strg);
		int v=MPTD(cr + 1, cc, er, ec,strg);
		
		strg[cc][cr]=h+v;
		
		return h+v;
	}
	
	public static int MPBU(int er,int ec) {
		
		int [][] strg=new int[er+2][ec+2];
		
		
		for(int row=er;row>=0;row--) {
			for(int col=ec;col>=0;col--) {
				
				if(row==er && col==ec) 
					strg[row][col]=1;
				else 
					strg[row][col]=strg[row][col+1]+strg[row+1][col];
				
			}
		}
		return strg[0][0];
	}
	
	
	public static int MPBUSE(int er,int ec) {
		
		int [] strg=new int[ec+1];
		
		Arrays.fill(strg,1);
		
		for(int slide=er-1;slide>=0;slide--) {
			for(int col=ec;col>=0;col--) {
				
				if(col==ec) {
					strg[col]=1;
				}else {
					strg[col]=strg[col]+strg[col+1];
				}
			}
		}
		return strg[0];
	}
	
	
	
	
	
	
	
	
	
	

}
