package com.thread;

import java.util.HashMap;
import java.util.Map;

public class PracticeTest {

	

    public static void main(String args[] ) throws Exception {
        System.out.println("Hello World");
        
        
        String[] inStr = new String[3];
        inStr[0]="avinash forty-nine";
        inStr[1]="alex seven";
        inStr[2]="avinash forty-five";
        Sort(inStr);

        for (String str: inStr){
            System.out.println(" String: " +str);
        }
        
    }
    
    private static Integer getInt(String numberString){
        Map<String, Integer> numberStringMap = new HashMap<>();
        numberStringMap.put("forty-nine", 49);
        numberStringMap.put("seven", 7);
        numberStringMap.put("forty-five", 45);

        return numberStringMap.get(numberString);
    }
    
    public static void Sort(String[] inStr){
        String[] nameNumber = new String[2];
        String name;
        String number;
        String[] nameNumberInner = new String[2];
        String nameInner;
        String numberInner;
        for (int i =0; i< inStr.length; i++){
            String temp;

            
            for (int j=0; j< inStr.length -i; j++){
            	nameNumber = inStr[j].split(" ");
                name=nameNumber[0];
                number = nameNumber[1];
             nameNumberInner = inStr[j+1].split(" ");
            nameInner=nameNumberInner[0];
            numberInner = nameNumberInner[1];
            System.out.println(" nameInner: " +nameInner);
            System.out.println(" numberInner: " +numberInner);
            System.out.println(" name: " +name);
            System.out.println(" number: " +number);

            if(nameInner.compareTo(name) < 0){
                
            System.out.println(" String SWAP: " +nameInner.compareTo(name));

              //swap with i, j;
              temp = inStr[j];
              inStr[j+1] = inStr[j];
              inStr[j] = temp;
                
            } else if (nameInner.equals(name)){
                if(getInt(numberInner) > getInt(number)){
                    //swap with i, j;
                	temp = inStr[j];
                    inStr[j+1] = inStr[j];
                    inStr[j] = temp;
                }
            }
                
            }
            }
        }
        
    

}
