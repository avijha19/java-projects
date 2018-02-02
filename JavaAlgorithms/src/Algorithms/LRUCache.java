package Algorithms;
import java.util.HashMap;

public class LRUCache {
	
	private HashMap<Integer,NodeLRU> mapLRU = new HashMap<Integer,NodeLRU>();
	private NodeLRU head;
	private NodeLRU tail;
	int capacity = 5;
	
	private void put (Integer key, Integer value){
		
		if(mapLRU.containsKey(key)){
			NodeLRU oldNode = mapLRU.get(key);
			
		}else{
			if(mapLRU.size()<capacity){
				
				NodeLRU newNode = new NodeLRU(key, value);
				setHead(newNode);
				
				
			}else{
				
			}
		}
		
	}
	
	private void removeNode(NodeLRU newNode){
		
	}
	
	private void setHead(NodeLRU newNode) {
		
		newNode.next= head;
		newNode.pre = null;
		
		if(head !=null){
			head.pre = newNode;
		}
		
		head = newNode;

		
		if(tail==null){
			tail = newNode;
		}
		
	}
}


class NodeLRU {
	public Integer key;
	public Integer value;
	public NodeLRU pre;
	public NodeLRU next;

	public NodeLRU (Integer key,Integer value){
		this.key = key;
		this.value = value;
	}
}
