package Collections;
import java.util.HashMap;
import java.util.Map;

import CarComparable.Car;

public class HashTableExample {
	
	private static  Map<Car, String> map1= new HashMap<Car, String>();

	
	public static void main(String args[]){
		
		Car c1 =new Car();
		c1.setColor("blue");
		c1.setModel(new Integer(2017));
		c1.setName("c1");
		Car c2 = new Car();
		c2.setColor("red");
		c2.setModel(2018);
		c2.setName("c2");

		
		String p1= "Avinash";
		String p2= "Abha";
		
		
		putMethod(c1,c2,p1,p2);
		
		Car c3 =new Car();
		c3.setColor("blue");
		c3.setModel(new Integer(2017));
		//c3.setModel(2019);
		c3.setName("c1");


		System.out.println("c1 equals c3: " + c1.equals(c3));
		System.out.println("c1 car person is: " + map1.get(c3));
	}
	
	private static void putMethod (Car c1, Car c2, String p1, String p2){
		
		map1.put(c1, p1);
		map1.put(c2, p2);
	}

}
