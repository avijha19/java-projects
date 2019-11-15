package LeetCode.LinkedLists;

//https://leetcode.com/problems/merge-k-sorted-lists/
//Example:
//
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6

public class MergedkSortedList {

	public static void main(String[] args) {

		ListNode headA = convertToHeadListNode(1368);
		ListNode headB = convertToHeadListNode(459);
		ListNode headC = convertToHeadListNode(27);

		
		System.out.println("First Number: " +convertToNumber(headA ));
		System.out.println("Second Number: " +convertToNumber(headB ));		
		ListNode[] lists = new ListNode[] {headA, headB, headC};
		ListNode mergedNode = mergeKLists(lists);
		System.out.println("Merged Number: " +convertToNumber(mergedNode ));
	}
	
	
	
	//brute force
	private static ListNode mergeKLists(ListNode[] lists) {
		
	
		ListNode current = null;
		ListNode merged = null;

		
		for(int i =0; i<lists.length; i++ ) {
			current = lists[i];
			merged = mergeTwoLists(merged, current);
		}
		
		
		return merged;
	}
	

	//leet code answer
		public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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
