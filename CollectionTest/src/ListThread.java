import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListThread implements Runnable{
	
	private List<String> myList;
	Map<String, Integer> myMap;

	
	public ListThread(List<String> myList, Map<String, Integer> myMap){
		this.myList = myList;
		this.myMap = myMap;
	}

	@Override
	public void run() {
		CollectionTest test = new CollectionTest();
		//test.testList(myList);		
		test.testMap(myMap);
	}

}
