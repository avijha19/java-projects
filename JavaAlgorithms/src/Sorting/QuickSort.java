package Sorting;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 9, 4, 6, 3, 7, 1, 2, 11, 5 };

		printArray(arr);
		
		quickSort(arr, 0, arr.length -1);
		
		System.out.println("Print Quick Sort");
		
		printArray(arr);

		
		
	}

	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot-1 );
			quickSort(array, pivot + 1,end);
		}
	}//end of method
	
	/*static int partition(int[] array, int p, int q) {
		int pivot = q;
		int i = p-1;
		for (int j = p; j <= q; j++) {
			if (array[j] <= array[pivot]) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		return i;

	}*/
	//end of method
	
	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		int i = start -1;
		
		for (int j = start; j <= end; j ++) {
			if (arr[j] <= pivot) {
				
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j]=temp;
				
			}else {
				continue;
			}
		}
		
		
		return i;
		
	}
	

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("," + arr[i]);
		}

	}

}
