package com.udemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCacheDemo {

	public static void main(String[] args) {

	}
	
}
	class LRUCache {
	
		private Map<Integer, LNode> lMAp = new HashMap<>();
		
		LNode top = null;
		LNode last = null;		
		int capacity = 5;
		int len=0;
		

	    public LRUCache(int capacity) {
	    	this.capacity = capacity;
	    	
	    }
	    
	    
	    
	    public int get(int key) {
	    	
	    	
	    	
			return key;        
	    }
	    
	    
	    public void deletNode(LNode node) {
	    	
	    	LNode curr = top;
	    	
	    	while(curr != null) {	
	    		
	    		if((curr.getValue() == node.getValue())
	    				&& curr.getKey() == node.getKey()) {
	    			curr.getPrev().setNext(curr.getNext());
	    			curr.getNext().setPrev(curr.getPrev());	
	    			
	    			lMAp.remove(node.getKey());
	    		}
	    			
		    		curr=curr.getNext();
          	}
	    		    	
	    }
	    
	    
	    public void setTop(LNode node) {
	    	
	    	if(top == null) {
	    		top=node;
	    	} else {
	    		top.prev=node;
	    		node.next=top;
	    		top=node;
	    	}
	    	
	    	if(last == null) {
	    		last = node;
	    	}
	    }
	    	
	    
	    public void put(Integer key, int value) {
	    	
	    	if (lMAp.containsKey(key)) {
	    		LNode oldNode = lMAp.get(key);
	    		deletNode(oldNode);
	        	setTop(oldNode);
        		lMAp.put(key, oldNode);
	    	
	         } else {
	        	 LNode newNode = new LNode(key,value);
	        	 if (len< capacity) {
	        		 setTop(newNode);
	        		 lMAp.put(key, newNode);		 
	        	 } else {
	        		 last.getPrev().setNext(newNode);
	        		 last=newNode;
	        		 lMAp.remove(capacity);
	        		 lMAp.put(key, newNode);
	        		 
	        	 }
	    	
	         }
	    
	    
	        
	 }
	

	
	
	class LNode {
		int key;
		int value;
		LNode prev;
		LNode next;
		
		public LNode (int key, int value) {
			this.value = value;
			this.key = key;

		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public LNode getPrev() {
			return prev;
		}

		public void setPrev(LNode prev) {
			this.prev = prev;
		}

		public LNode getNext() {
			return next;
		}

		public void setNext(LNode next) {
			this.next = next;
		}
		
		
		
		
	}
	
}
