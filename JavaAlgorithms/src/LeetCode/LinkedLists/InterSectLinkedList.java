package LeetCode.LinkedLists;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//Output: Reference of the node with value = 8

public class InterSectLinkedList {

	public static void main(String[] args) {
		ListNode headA = convertToHeadListNode(41845);
		System.out.println(" A Number: " + convertToNumber(headA));

		ListNode headB = convertToHeadListNode(501845);
		System.out.println(" B Number: " + convertToNumber(headB));


		ListNode intesect = getIntersectionNode(headA, headB);
		
		System.out.println(" new Number: " + convertToNumber(intesect));
		
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        
        ListNode smaller = sizeA > sizeB ? headB : headA;
        ListNode larger = sizeA > sizeB ? headA : headB;
        
        int gap = Math.abs(sizeA - sizeB);
        for(int i = 1; i <= gap; i++){
            larger = larger.next;
        }
        
        while(larger != null && smaller != null) {
            if(larger == smaller){
                return larger;
            }
            larger = larger.next;
            smaller = smaller.next;
        }
        return null;
    }
    
    static int getSize(ListNode node){
        int size = 0;
        while(node != null){
            ++size;
            node = node.next;
        }
        return size;
    }
    
    
	
	//Avinash
    public static ListNode getIntersectionNodeAvinash(ListNode headA, ListNode headB) {
    	
    	ListNode intesect = null;
    	
    	ListNode currentA = headA;
    	ListNode currentB = headB;

    	
    	
    	while(currentA!=null && currentB!=null) {
    		
    		
    		
    		if(currentA.val == currentB.val) {
    			intesect = currentA;
    			return intesect.next;
    		}
    		
    			currentA = currentA.next;
        		currentB = currentB.next;
    		
    		
    		if(currentA.next == null) {
    			currentA = headB;
    		}
    		
    		if(currentB.next == null) {
    			currentB = headA;
    		}
    	}
    	
    	
		return intesect.next;
        
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
