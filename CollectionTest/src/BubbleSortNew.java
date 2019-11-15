import java.util.Arrays;
import java.util.List;

public class BubbleSortNew {

	public static void main(String[] args) {

	    Integer[] intarr = {12,4,0,1,7,11,13};
	    System.out.println(Arrays.asList(intarr));
	    bubbleSort(Arrays.asList(intarr));
	    System.out.println(Arrays.asList(intarr));

	}
	   
	private static void bubbleSort(List<Integer> intList){
	        
	        for(int i=0; i<intList.size(); i++){
	            for (int j = 0; j <intList.size()-1-i; j++ ){
	                int temp = intList.get(j);
	                if(intList.get(j+1) < intList.get(j)){
	                    
	                    intList.set(j, intList.get(j+1));
	                    intList.set(j+1, temp);                    
	                }
	            }
	        }
	    }
	    
		
	}


