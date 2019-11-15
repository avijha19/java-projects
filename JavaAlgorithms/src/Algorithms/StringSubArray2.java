package Algorithms;

//VIKAS PROBLEM

// please find the starting index of any subarray in given string
//char[] in = new char[]{'a','b','c','d','e','f','g'};
//char[] sub = new char[] {'d','e','f'};
// ans =3

public class StringSubArray2 {

	public static void main(String[] args) {
		
		char[] in = new char[]{'a','b','c','d','e','f','g'};
		char[] sub = new char[] {'d','e','f'};
		
		int startIndex = getStartindex3(in, sub);
		System.out.println(" Sub Array: " +startIndex);
		startIndex =  getStartindex2(in, sub);
		System.out.println(" Sub Array 2: " +startIndex);

	}

	private static int getStartindex(char[] in, char[] sub) {
		
		int startIn = -1;
		int startSub = 0;
		
		for (int i=0; i< in.length; i++) {
			
			if(startIn > -1 && startSub < sub.length) {
				
				if(in[i]==sub[startSub]) {
						startSub ++;
					
				} else {
					startIn = -1;
					startSub = 0;
					
				}
			} else  {
				if(startSub < sub.length) {
					if(in[i]==sub[startSub]) {
						startIn =i;
						startSub ++;
					}
				}
			}
			
		}
		
		return startIn;
	}
	
	
	private static int getStartindex3(char[] in, char[] sub) {

		int startIn = -1;
		int startSub = 0;

		for (int i = 0; i < in.length; i++) {
			if (startSub < sub.length) {
				if (startIn > -1) {
					if (in[i] == sub[startSub]) {
						startSub++;
					} else {
						startIn = -1;
						startSub = 0;
					}
				} else {
					if (in[i] == sub[startSub]) {
						startIn = i;
						startSub++;
					}
				}

			} else {
				break;
			}
		}

		return startIn;
	}
	
	
	
	private static int getStartindex2(char[] in, char[] sub) {

		int startSub = 0;

		for (int i = 0; i < in.length; i++) {
			if (i == in.length - 1 && startSub == sub.length - 1) {
				return in.length - sub.length;
			}

			if (startSub < sub.length) {
				if (in[i] == sub[startSub]) {
					startSub++;
				} else {
					startSub = 0;
				}
			} else {
				return i - sub.length;
			}
		}

		return -1;
	}
	
	
	

}
