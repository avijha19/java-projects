package Algorithms;

public class Interview {

	public static void main(String[] args) {
		
		//7->5->2  257
		//5 ->6->4 475
		//_______________
		 //            732
	   //	7 -> 2 ->2
		
	   /*
	 
	 
	-1 -> null
	-1 -> 2 -> null
	-1 -> 3 ->2 -> null
	-1 ->  7 ->3 -> 2-> null
	 	
	 
	 */
		
		ListNode list1 = new ListNode(7);
		list1.next = new ListNode(5);
		list1.next.next = new ListNode(2);

		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(7);
		list2.next.next = new ListNode(4);
		
//		ListNode list1 = new ListNode(5);
//		ListNode list2 = new ListNode(5);
		
		System.out.println("sum: "  + sumList(list1,list2).val);

	}

	private static ListNode sumList(ListNode list1, ListNode list2) {
		ListNode result = new ListNode(-1);

		ListNode addNode = result.next;
		ListNode temp = null;

		int carry = 0;
		int sum = 0;

		while (true) {

			if (list1 != null && list2 != null) {

				sum = carry + list1.val + list2.val; // 12, 13, 7
				carry = sum / 10;// 1,1, 0
				sum = sum % 10;// 2,3, 7

				temp = addNode;//null,2
				addNode = new ListNode(sum); //2,3,7
				addNode.next = temp;// null , 2, 7

				list1 = list1.next;
				list2 = list2.next;

			} else if (list1 != null && list2 == null){
				sum = carry + list1.val ; // 12, 13, 7
				carry = sum / 10;// 1,1, 0
				sum = sum % 10;// 2,3, 7

				temp = addNode;//null,2
				addNode = new ListNode(sum); //2,3,7
				addNode.next = temp;// null , 2, 7

				list1 = list1.next;
				
			} else if (list2 != null && list1 == null) {
				sum = carry + list2.val ; // 12, 13, 7
				carry = sum / 10;// 1,1, 0
				sum = sum % 10;// 2,3, 7

				temp = addNode;//null,2
				addNode = new ListNode(sum); //2,3,7
				addNode.next = temp;// null , 2, 7

				list2 = list2.next;
				
			} else {
				break;
			}

			

		}
		
		if(carry > 0) {
			   result.next =  new ListNode(carry);
			   result.next.next = addNode;
		   } else {
			   result.next = addNode;
		   }

//		if (carry > 0) {
//
//			addNode = new ListNode(carry);
//			//addNode.next = temp;
//			result.next.next = addNode;
//			
//			
//			
//		} else {
//			result.next = addNode;
//		}

		return result.next;

	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;

	}
}
