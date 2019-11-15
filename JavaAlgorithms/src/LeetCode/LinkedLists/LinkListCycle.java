package LeetCode.LinkedLists;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/solution/

public class LinkListCycle {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next;
		//head.next.next.next.next.next = null;

		
		System.out.println("Has Cycle: " +hasCycle2(head));

	}
	
	//hash set solution
	
    public static boolean hasCycle(ListNode head) {
    	boolean cycle = false;
    	Set<ListNode> nodeSet = new HashSet<>();
    	
    	while (head!= null) {
    		if(nodeSet.contains(head)) {
    			cycle = true;
    			break;
    		}
    		nodeSet.add(head);
    		head = head.next;
    		
    	}
		return cycle;
        
    }
    
	//twopointer
	
    public static boolean hasCycle2(ListNode head) {
    	boolean cycle = true;
    	
    	 if (head == null || head.next == null) {
    	        return false;
    	    }
    	
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(fast !=slow) {
    		if(fast==null || fast.next ==null) {
    			cycle = false;
    			break;
    		}
    		slow =  slow.next;
    		fast = fast.next.next;
    		
    	}
		return cycle;
        
    }

}
