import java.util.Arrays;
import java.util.List;


public class BubbleSort {

    public static void main(String[] args) {
    Integer[] intarr = {2,4,0,1,7,8,5};
    System.out.println(Arrays.asList(intarr));
    bubbleSort(Arrays.asList(intarr));
    System.out.println(Arrays.asList(intarr));


    }
    
    
    private static void bubbleSort(List<Integer> intList){
        
        for(int i= 0; i<intList.size(); i++){
            for (int j = i + 1; j <intList.size(); j++ ){
                int temp = intList.get(i);
                if(intList.get(i) > intList.get(j)){
                    
                    intList.set(i, intList.get(j));
                    intList.set(j, temp);                    
                }
            }
        }
    }

}
