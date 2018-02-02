package CarComparable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CarComparableWorker {
	
	private static  List<Car> arraylst= new ArrayList<Car>();
	private static  List<Car> linkedlst = new LinkedList<Car>();
    private static  Set<Car> treeSet = new TreeSet<Car>();
	private static  Map<Car, String> map1= new TreeMap<Car, String>();

	public static void main(String args[]){
		
		Car c1 =new Car();
		c1.setColor("blue");
		c1.setModel(new Integer(2030));
		
		Car c2 = new Car();
		c2.setColor("red");
		c2.setModel(new Integer(2018));

		Car c3 =new Car();
		c3.setColor("green");
		c3.setModel(new Integer(2031));
		//c3.setModel(2019);
	
		String p1= "Avinash";
		String p2= "Abha";
		String p3= "Aatreya";

		//putArrayListMethod(c1,c2,p1,p2);
		putTreeMapMethod(c1,c2,c3,p1,p2,p3);
		System.out.println("Size: " +map1.size());
		
		for(Map.Entry<Car, String> entry: map1.entrySet()){
			System.out.println("key: " + entry.getKey().getModel());
		}
		
	}
	
	private static void putTreeMapMethod (Car c1, Car c2, Car c3,
			String p1, String p2, String p3){
		
		map1.put(c1, p1);
		map1.put(c2, p2);
		map1.put(c3, p3);

	}

}
