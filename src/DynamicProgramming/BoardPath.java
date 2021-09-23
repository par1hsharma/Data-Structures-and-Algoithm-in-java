package DynamicProgramming;

public class BoardPath {

	public static void main(String[] args) {
		
		int curr=0;
		int end=10;
		System.out.println(BPrec(curr,end));
		System.out.println(BPTD(curr,end,new int[end+1]));
		System.out.println(BPBU(end));
		System.out.println(BPBUSE(end));

	}
//TC:6^n
	public static int BPrec(int curr, int end) {

		if (curr == end)
			return 1;

		if (curr > end)
			return 0;
		
		int count=0;

		for (int dice = 1; dice <= 6; ++dice) {

			count+=BPrec(curr + dice, end);
		}
		return count;
	}
//	TC:n
	public static int BPTD(int curr,int end,int[] strg) {
		
		if (curr == end)
			return 1;

		if (curr > end)
			return 0;
		
		int count=0;
		
		if(strg[curr]!=0)
			return strg[curr];

		for (int dice = 1; dice <= 6; ++dice) {

			count+=BPTD(curr + dice, end,strg);
		}
		
		strg[curr]=count;
		return count;
		
	}
//	TC:n  SC:n
	public static int BPBU(int end) {
		
		int[] strg=new int[end+6];
		
		strg[end]=1;
		
		for(int i=end-1;i>=0;i--) {
			strg[i]=strg[i+1]+strg[i+2]+strg[i+3]+strg[i+4]+strg[i+5]+strg[i+6];
		}
		return strg[0];
	}
	public static int BPBUSE(int end) {
		
		int[] strg=new int[6];
		strg[0]=1;
		
		for(int slide=1;slide<=10;slide++) {
			int sum=strg[0]+strg[1]+strg[2]+strg[3]+strg[4]+strg[5];
			
			strg[5]=strg[4];
			strg[4]=strg[3];
			strg[3]=strg[2];
			strg[2]=strg[1];
			strg[1]=strg[0];
			strg[0]=sum;
		}
		
		return strg[0];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
