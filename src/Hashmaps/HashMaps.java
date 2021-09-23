package Hashmaps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMaps {

	public static void main(String[] args) {
		
		HashMap<String,Integer> map= new HashMap();
		
		map.put("USA", 100);
		map.put("UK", 175);
		map.put("India", 200);
		map.put("sweden", 300);
		map.put("sweden", 310);
		
		map.get("usa");
		System.out.println(map);
		
		
		System.out.println(map.remove("USA"));
		
		System.out.println(map);
		
		System.out.println(map.get("India"));// to get the value
		
		System.out.println(map.containsKey("India"));
		
		// for printing keys
		Set<String> keys = map.keySet();
		
		for(String key:keys) //this loop is only used for reading.Values can't be changed from this loop
		{ 
			System.out.println(key);
		}
		// for printing values
		Collection<Integer> values=map.values();
		
		
		for(Integer value:values) {
			System.out.println(value);
		}
//		for printing the key value pair together
		Set<Map.Entry<String, Integer>> entrysets=map.entrySet();
		for(Map.Entry<String, Integer> entry:entrysets) {
			System.out.println(entry.getKey()+ "->" +entry.getValue());
		}
		
		
		
		
		
		

	}

}
