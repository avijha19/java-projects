package LeetCode.LinkedLists;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/linked-list-cycle-ii/
//Example 1:
//
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the second node.
//
//
//Example 2:
//
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the first node.
//
//
//Example 3:
//
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.

public class LinkedListCycle2 {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next;
		//head.next.next.next.next.next = null;

		
		ListNode cycleNode = detectCycle(head);
		System.out.println("Cycle Node: " + cycleNode.val);
		
       
	
	}
	
	//Avinash Solution
	public static ListNode detectCycle(ListNode head) {
		
		Map<ListNode, Integer> mapNode =  new HashMap<>();
		ListNode current = head;
		ListNode cycleNode = null;
		int i = 0;
		while(current!=null) {
			if(mapNode.containsKey(current)) {
				cycleNode = current;
				break;
				
			} else {
				mapNode.put(current, i);
				current = current.next;
				i++;
			}
		}
		
		return cycleNode;

	}

}
