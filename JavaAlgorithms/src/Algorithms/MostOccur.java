package Algorithms;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MostOccur {

	public static void main(String[] args) {

		mostOccur(new int[]{4, 5, 8, 7, 4, 7, 6,7});
		
		mostOccur(new int[]{1, 2, 7, 5, 3, 6});
		
	}
	
	
	private static void mostOccur(int[] arr){
		
		//int count = 1;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i<arr.length; i++){
			int count=1;
			if(map.containsKey(arr[i])){
				count = map.get(arr[i]) +1;
				map.put(arr[i], count);
			}
			else{
				map.put(arr[i], count);
			}
		}
		
		
	//Entry<Integer,Integer> entry= (Entry<Integer, Integer>) map.entrySet();
	Set<Entry<Integer,Integer>> entries= map.entrySet();
	
	int tempCount =1;
	int tempValue = 0;
	for(Entry<Integer,Integer> entry: entries){
		if (entry.getValue() >tempCount ){
			tempCount = entry.getValue();
			tempValue = entry.getKey();
		}else{
			
		}
	}
	if(tempValue == 0){
		System.out.println("All are same");
	
	} else{
		System.out.println("Most occuring number is: " + tempValue + "   and count is: " + tempCount);

	}
	
	
	
		
	}
	
	
	
	

}
