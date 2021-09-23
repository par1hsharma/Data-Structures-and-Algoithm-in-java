package Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		// Intersection of 2 Arrays
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] arr2 = { 8, 9, 10, 11, 12, 3, 6 };
		//ArrayList<Integer> list = IntersectArrays(arr1, arr2);

		System.out.println(IntersectArrays(arr1, arr2));

	}

	private static ArrayList<Integer> IntersectArrays(int[] arr1, int[] arr2) {

		HashMap<Integer, Boolean> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], false);
		}
		for (int j = 0; j < arr2.length; j++) {
			if (map.containsKey(arr2[j])) {
				map.put(arr2[j], true);
			}
		}
		Set<Map.Entry<Integer,Boolean>> entries=map.entrySet();
		
		for(Map.Entry<Integer, Boolean> entry:entries) {
			if(entry.getValue()) {
				list.add(entry.getKey());
			}
		}
		return list;
		
		
		
	}

}
