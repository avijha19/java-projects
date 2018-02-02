package Algorithms;
import java.util.Arrays;

public class StringRepeatingChar {
	
	
	public static void main( String[] args){
		
		String str= "Avinaash";
		char[] charr = str.toCharArray();
		Arrays.sort(charr);
		//String str = "";
		System.out.println("String" +  str);
		boolean isRepated = false;
		for (int i=0; i<str.length(); i++){
			for (int j=i+1; j < str.length(); j++ ){
				if(str.charAt(i)==str.charAt(j)){
					isRepated = true;
					break;
				} else {
					continue;
				}
			}
		}
		System.out.println( "isRepated: " + isRepated);		
	}
	
	
	private boolean isRepeated(String str){
		boolean isRepeated = false;
		
		Arrays.sort(str.toCharArray());
		
		

		return  isRepeated;
	}

}
