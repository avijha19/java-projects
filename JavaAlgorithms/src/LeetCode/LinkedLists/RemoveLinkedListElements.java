package LeetCode.LinkedLists;

public class RemoveLinkedListElements {
	
	//Input:  1->2->6->3->4->5->6, val = 6
	//Output: 1->2->3->4->5
	//https://leetcode.com/problems/remove-linked-list-elements/
	

	public static void main(String[] args) {

		ListNode head = convertToHeadListNode(123456);
		System.out.println("Before Deleting: " + convertToNumber(head));
		System.out.println("Node to be deleted: " + 6);
//		removeElements(head, 6);
//		System.out.println("After Deleting: " + convertToNumber(head));
		
		removeElementsLeetCode(head, 6);
		System.out.println("After Deleting: " + convertToNumber(head));

		
	}
	
	// need to calculate the difference between removeElementsLeetCode and removeElements
	public static ListNode removeElementsLeetCode(ListNode head, int val) {
	    ListNode sentinel = new ListNode(0);
	    sentinel.next = head;

	    ListNode prev = sentinel, curr = head;
	    while (curr != null) {
	      if (curr.val == val) prev.next = curr.next;
	      else prev = curr;
	      curr = curr.next;
	    }
	    return sentinel.next;
	  }
	
	
	 public static ListNode removeElements(ListNode head, int val) {
		 

	    	ListNode current = null;
	    	ListNode prev = null;
	    	if(head.val == val){
	    		head = head.next;
	    		return head;
	    	} else {
	    		current = head.next;
	    		prev = head;
	    		while(current!=null) {
	    			if (current.val == val) {
	    				prev.next = current.next;
	    				return head;
	    			} else {
	    				current = current.next;
	    				prev = prev.next;
	    			}
	        	}
	    	} 
		 
		return head;
	        
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
