package Algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostOccurTest {

		public static void main(String[] args) {

			mostOccur(new int[]{4, 5, 8, 7, 4, 7, 6,7});
			
			mostOccur(new int[]{1, 2, 7, 5, 3, 6});
			
		}

		private static void mostOccur(int[] is) {
			//Integer[] test =  new Integer[5];
			
			
			Map<Integer, Integer> numberCount = new HashMap<>();
			
			
			for (int i=0; i<is.length; i++ ) {
				if(null==numberCount.get(i)) {
				numberCount.put(i, 1);
				} else {
					numberCount.put(i, numberCount.get(i) +1);

				}
			}
			
			//Iterator<Integer> it = numberCount.keySet().iterator();
			Set<Entry<Integer, Integer>> entries= numberCount.entrySet();
			
			int maxcount=1;
			int maxvalue = 0;
			for(Entry<Integer, Integer> entry: entries) {
				if (entry.getValue()>maxcount) {
				maxcount = entry.getValue();
				maxvalue = entry.getKey();
				}
				
			}
			
			if(maxvalue == 0) {
				System.out.println("All numbers are same");
			} else {
				System.out.println("Most occurance" + maxvalue + "and count" +maxcount);

			}
			
			
			

			
			
			// TODO Auto-generated method stub
			
		}
	}


