package Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

public class Compliment {

	public static void main(String[] args) {


		int[] in = new int[] {2, 5, 4, 15};
		int target = 9;
		
		int[] retArr = getCompliment(in,9);
		System.out.println("Array: " + Arrays.toString(retArr));

	}
	
	private static int[] getCompliment(int[] in, int target) {
		int[] retArr = new int[2];
		
		Map<Integer, Integer> complimentMap =  new HashMap<>();
		
		for (int i = 0; i < in.length; i++) {
			complimentMap.put( target - in[i], i);
			if (complimentMap.get(in[i]) != null) {
				retArr[0]= complimentMap.get(in[i]);
				retArr[1] = i;
				break;
			}
		}
		return retArr;
	}

}
