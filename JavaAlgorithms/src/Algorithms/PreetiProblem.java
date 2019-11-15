package Algorithms;

import java.util.HashMap;
import java.util.Map;

public class PreetiProblem {

	public static void main(String[] args) {

		int[][] inArr = new int[][] { { 1, 2, 5 }, { 2, 4, 10 }, { 1, 3, 12 }, { 2, 5, 6 }, { 6, 9, 5 } };

		System.out.println("Integer: " + getMax(inArr));

	}

	private static int getMax(int[][] inArr) {
		int sum = 0;
		Map<Integer, Integer> mapCount = new HashMap<>();
		int start;
		int end;
		int temp;
		int max = 0;

		for (int i = 0; i < inArr.length; i++) {

			start = inArr[i][0];
			end = inArr[i][1];
			sum = inArr[i][2];

			if (mapCount.containsKey(start)) {
				temp = mapCount.get(start);
				mapCount.put(end, temp + sum);
				max = Math.max(max, temp + sum);
			} else {
				mapCount.put(end, sum);
				max = Math.max(max, sum);
			}

		}

		return max;

	}
	
	
	class StartEnd {
		private int start;
		private int end;
		private int sum;
		
		public StartEnd(int start, int end, int sum) {
			this.start=start;
			this.end = end;
			this.sum = sum;
		}
		
	   @Override	
		public boolean equals(Object o) {

			if (o == this) {
				return true;
			}

			if (!(o instanceof StartEnd)) {
				return false;
			}
			
//			if(this.end == (StartEnd)  && this.start == o.start) {
//				
//			}

			return true;

		}
	   
		
		
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public int getSum() {
			return sum;
		}
		public void setSum(int sum) {
			this.sum = sum;
		}
		
		
		
	}

}
