package Algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostOccuring {
	
	
	public static void main (String argg[]){
		
		Integer testArray[] = {1,2,3,4,1,5,2,2,5,6,6,6,6};
		ArrayList<Integer> intList = new ArrayList<>( Arrays.asList(testArray));
		
		List<Integer> intList2 = (List<Integer>) Arrays.asList(testArray);
	
		System.out.println("List: Array: " + intList);
		System.out.println("Class Name: " +  intList.getClass());
		System.out.println("Class Name: " +  intList2.getClass());

		
		System.out.println("MostOccored: " +  MostOccuring(intList2));
		
	}
	
	
	private static int MostOccuring(List<Integer> testList){
		
		int tempCount=1;
		int temp=(int) testList.get(0);
		
		for(int i=0; i<testList.size()-1; i++){
			
			int count=0;
			for(int j=0; j< testList.size()-1; j++){
				
				if(testList.get(i).equals(testList.get(j))){
					count++;
				}
			}
			
			if(count>tempCount){
				tempCount=count;
				temp= (int) testList.get(i);
			}
			
		}
		
		return temp;
	}

}
