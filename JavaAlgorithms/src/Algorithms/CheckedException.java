package Algorithms;
import java.io.*; 


public class CheckedException {

	public static void main(String[] args) {
		FileReader file;
		try {
			file = new FileReader("C:\\test\\a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        //BufferedReader fileInput = new BufferedReader(file); 
          
        // Print first 3 lines of file "C:\test\a.txt" 
       // for (int counter = 0; counter < 3; counter++)  
            //System.out.println(fileInput.readLine()); 
          
      //  fileInput.close(); 
	}
	
	
	  
	
}
