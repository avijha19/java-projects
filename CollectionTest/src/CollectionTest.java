import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class CollectionTest {
	
	
	public static  void main(String args[]){
		
//		testList();
//		testMap();
		
//		List<String> myList = new CopyOnWriteArrayList<String>();
//		List<String> myList = new ArrayList<String>();
//		
//		myList.add("1");
//		myList.add("2");
//		myList.add("3");
//		myList.add("4");
//		
//		Map<String, Integer> myMap = new HashMap<String, Integer>();
//		 
//		myMap.put("key1", 1);
//		myMap.put("key2", 2);
//		myMap.put("key3", 3);
//		
//		Thread th1 = new Thread(new ListThread(myList,myMap));
//		Thread th2 = new Thread(new ListThread(myList,myMap));
//		th1.start();
//		th2.start();
		
		//Concurrent modification exceprion
/*		Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        
        Iterator<String> iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }*/
        
		ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        
        Iterator<String> iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
        
        System.out.println("HashMap" + premiumPhone);
	}
	
	public void testMap(Map<String, Integer> myMap ){
		//test Map
        for (String key : myMap.keySet()) {
			if (myMap.get(key) == 1)
				myMap.remove(key);
		}
		
		/*Iterator<String> it = myMap.keySet().iterator();
		while (it.hasNext()){
			String value = it.next();
			if(value.equals("key1"))
			it.remove();
		}*/
        
        System.out.println("Successfully removed a pair!" + myMap);
	}
	
	public void testHashTable(Map<String, Integer> myMap ){
		//test Map
        for (String key : myMap.keySet()) {
			if (myMap.get(key) == 1)
				myMap.remove(key);
		}
        
		/*Iterator<String> it = myMap.keySet().iterator();
		while (it.hasNext()){
			String value = it.next();
			if(value.equals("key1"))
			it.remove();
		}*/
        
        System.out.println("Successfully removed a pair!" + myMap);
	}
	
	public void  testList(List<String> myList){
		
		     
				// To avoid concurrentmodificationexception synronize the list
				synchronized(myList){
					//Iterate through iterator
			        Iterator<String> it = myList.iterator();

			        while(it.hasNext()){
			        	String value = it.next();
			        	System.out.println(" String value: " + value);
			        	if(value.equals("3")) {
			        		//myList.remove(value);
			        		it.remove();
			        	}
			        }	
				}
				//Iterate through iterator
		       /* Iterator<String> it = myList.iterator();

		        while(it.hasNext()){
		        	String value = it.next();
		        	System.out.println(" String value: " + value);
		        	if(value.equals("3")) {
		        		//myList.remove(value);
		        		it.remove();
		        	}
		        }*/
		        
		        //Through traditional for loop
		        /* 
		        for(int i = 0; i< myList.size(); i++){
		        	String value = myList.get(i);
		        	System.out.println("Values are: " + value);
		        	if(value.equals("3")) {
		            	myList.remove(i);
		        	}
		        }*/
		        
		        //through for each loop
		        /*for(String value: myList){
		        	System.out.println("Values are: " + value);
		        	if(value.equals("3")) 
		        	myList.remove(value);
		        	
		        }*/
		        
				System.out.println("List" + myList);
		
	}

}
