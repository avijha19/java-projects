package Algorithms;



import java.util.*;
import java.io.*;

class SolutionMap{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        Map<String,Integer> phoneName = new HashMap<>();

		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
            phoneName.put(name, phone);
			in.nextLine();
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
            Integer phone = phoneName.get(s);
            if (null == phone){
             System.out.println("Not found");
            } else{
           System.out.println(in.nextLine() + "=" + phone);
            }
		}

       
	}
}
