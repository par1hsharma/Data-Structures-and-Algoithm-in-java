package Hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class getMaxFreqChar {

	public static void main(String[] args) {
		
		String str="aab";
		System.out.println(getMaxFreq(str));

	}
	
	public static char getMaxFreq(String str) {
		
		HashMap<Character, Integer> map=new HashMap<>();
		
		for(int i =0;i<str.length();i++) {
			
			char cc=str.charAt(i);
			if(map.containsKey(cc)) {
				int old_value=map.get(cc);
				int new_value=old_value+1;
				map.put(cc, new_value);
				
			}else {
				map.put(cc, 1);
			}
		}
		char maxChar='\0';
		int max=0;
		
		Set<Map.Entry<Character,Integer>> entries=map.entrySet();
		for(Map.Entry<Character, Integer> entry:entries) {
			if(entry.getValue()>max) {
				max=entry.getValue();
				maxChar=entry.getKey();
			}
		}
		return maxChar;
		
		
	}

}
