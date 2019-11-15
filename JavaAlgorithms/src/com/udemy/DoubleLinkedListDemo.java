package com.udemy;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoubleLinkedList test = new DoubleLinkedList();
		
//		test.insertFront(4);
//		test.insertFront(2);
//		test.insertFront(8);
//		test.insertFront(9);

	
		
		int number = 1221;
		int num = number;
        while (num!=0) {
        	//test.insertFront(num%10); 
        	num = num/10;  	   
       }
        
        String testString = "anAVVAna";
        	
        for (int i=0; i< testString.length(); i++) {
        	test.insertFront(testString.charAt(i));
        }
        
    	if (test.displayForward().equals(test.displayBackWard())){
    		
    		System.out.println("Is Palindrme");
    	} else {
    		System.out.println("Not Palindrme");

    	}
		
	}
	
}
	
	
	class DoubleLinkedList {
		
		private Node2 last;
		private Node2 first;
		
		public DoubleLinkedList () {
			last = null;
			first = null;
		}
		
		public void insertFront(char data) {
			
			Node2 newNode =  new Node2(data);
			
			if(first !=null) {
				newNode.setNext(first);
				first.setPrev(newNode);
			} else {
				last = newNode;
			}
			
			first = newNode;
			
		}
		
		public void insertLast(char data) {
			
			Node2 newNode =  new Node2(data);
			
			if(last !=null) {
				newNode.setPrev(last);
				last.setNext(newNode);
			} else {
				first = newNode;
			}
			
			last = newNode;
			
		}
		
		public String displayBackWard() {
			
			Node2 currNext = null;
			Node2 currPrev= last;
			String str="";
			while (currPrev!=null) {
				currNext=currPrev;
				System.out.println(currPrev.getData());
				str= str + currPrev.getData();
				currPrev=currPrev.getPrev();
				
			}
			
			return str;
			
			
		}
		
		public String displayForward() {
			
			Node2 currNext = first;
			Node2 currPrev= null;
			
			String str="";

			while (currNext!=null) {
				currPrev=currNext;
				//System.out.println("Data" +currPrev.ShowData() + ",");
				System.out.println(currNext.getData());
				str = str + currNext.getData();
				currNext=currNext.getNext();
				
			}
			
			return str;
		}
		
		
		
		
	}
	
	
	class Node2  {
		
		char data;
		Node2 next;
		Node2 prev;
		
		public Node2 (char data) {
			this.data = data;
		}
		
		public char getData() {
			return data;
		}
		public void setData(char data) {
			this.data = data;
		}
		public Node2 getNext() {
			return next;
		}
		public void setNext(Node2 next) {
			this.next = next;
		}
		public Node2 getPrev() {
			return prev;
		}
		public void setPrev(Node2 prev) {
			this.prev = prev;
		}
		
		public void ShowData() {
			System.out.println(" Data: " + this.data);
		}
			
	}


