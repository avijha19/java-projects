package LeetCode.LinkedLists;

//https://leetcode.com/problems/merge-two-sorted-lists/submissions/

//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.



public class MergeTwoLists {

	public static void main(String[] args) {
		ListNode headA = convertToHeadListNode(124);
		ListNode headB = convertToHeadListNode(134);
		
		System.out.println("First Number: " +convertToNumber(headA ));
		System.out.println("Second Number: " +convertToNumber(headB ));		
		//ListNode mergedNode = mergeTwoLists(headA, headB);
		ListNode mergedNode = mergeTwoLists2(headA, headB);

		System.out.println("Merged Number: " +convertToNumber(mergedNode ));

	}
	
	//avinash answer
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 
		 ListNode currentA = l1;
		 ListNode currentB = l2;
		 
		 ListNode mergedHead = null;
		 ListNode temp = null;
		 
		 
		 
		 while (currentA!= null || currentB!=null ) {
			 temp = mergedHead;
			 
			 if(currentA == null ) {
				 mergedHead = new ListNode(currentB.val);
				 currentB = currentB.next; 
			 }  else if(currentB == null){
				 mergedHead = new ListNode(currentA.val);
				 currentA = currentA.next; 
			 } else if (currentA.val < currentB.val) {
				 mergedHead = new ListNode(currentA.val);
				 currentA = currentA.next;
			 } else {
				 mergedHead = new ListNode(currentB.val);
				 currentB = currentB.next;
			 }
			 mergedHead.next = temp;			 
		 }
		 
		 
		 ListNode reversedHead = null;
		  temp = null;
		  
		  while (mergedHead !=null) {
			  temp = reversedHead;
			  reversedHead = new ListNode(mergedHead.val);
			  reversedHead.next = temp;
			  mergedHead = mergedHead.next;
		  }
		 
		 
		return reversedHead;
	        
	    }
	
	//leet code answer
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

		ListNode currentA = l1;
		ListNode currentB = l2;
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

		while (currentA != null && currentB != null) {

			if (currentA.val < currentB.val) {
				prev.next = currentA;
				currentA = currentA.next;
			} else {
				prev.next = currentB;
				currentB = currentB.next;
			}
			
			prev = prev.next;
		}

		if (currentA == null) {
			prev.next = currentB;
		} else if (currentB == null) {
			prev.next = currentA;

		}

		return preHead.next;

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
