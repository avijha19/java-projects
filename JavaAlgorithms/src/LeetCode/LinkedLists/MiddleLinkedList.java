package LeetCode.LinkedLists;

// https://leetcode.com/problems/middle-of-the-linked-list/


//Example 1:
//
//Input: [1,2,3,4,5]
//Output: Node 3 from this list (Serialization: [3,4,5])
//The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
//Note that we returned a ListNode object ans, such that:
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
//Example 2:
//
//Input: [1,2,3,4,5,6]
//Output: Node 4 from this list (Serialization: [4,5,6])
//Since the list has two middle nodes with values 3 and 4, we return the second one.


public class MiddleLinkedList {

	public static void main(String[] args) {
		
		ListNode head = convertToHeadListNode(12345);
		ListNode middle = middleNode(head);
		
		System.out.println(" Middle Number: " + middle.val);

		System.out.println(" new Number: " + convertToNumber(middle));

	}
	
	 public static ListNode middleNode(ListNode head) {
		 
		 ListNode middle = head;
		 ListNode current = head;
		 
		 while(current.next !=null) {
			 
			 if(current.next.next!=null) {
				 current = current.next.next; //skip by 2
			 }else {
				 current = current.next;
			 }
			 middle = middle.next;
		 }
		 
		 return middle;
		 
	 }
	 
	 
	 //convert 708 to 7>0>8
	  private static ListNode convertToHeadListNode(int num) {
			
		    ListNode temp  = null;
			ListNode retListNode = null;
			int digit;
			if(num==0) {
				retListNode = new ListNode(0);
			}
			 while (num > 0) {
				digit = num % 10; // here first digit = 8
				num = num / 10;
				temp = retListNode;
				retListNode = new ListNode(digit);
				retListNode.next = temp;
			}
			 
			 return retListNode;
			
		}
	  
	// convert 7> 0> 8 to 708
		  private static int convertToNumber(ListNode in) {
				
				ListNode originalIn = in;
				int i =-1;
				//first calculate the size
				while (null!= in) {
					in = in.next;
					i++;
				}
				
				int num =0;
				while (originalIn != null) {
					num = (int) (originalIn.val * Math.pow(10, i) + num); // 200 + 40 + 3
					originalIn = originalIn.next;
					i--;
				}
				
				return num;

		}

}
