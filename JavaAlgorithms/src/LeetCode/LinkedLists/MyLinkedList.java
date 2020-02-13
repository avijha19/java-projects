package LeetCode.LinkedLists;

//https://leetcode.com/problems/design-linked-list/submissions/

//["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]

//[null,null,null,null,null,null,null,null,4,null,null,null]


	class MyLinkedList {
		
		class ListNode {
			  int val;
			  ListNode next;
			  ListNode(int x) { val = x; }
			}
	
	  int size;
	  ListNode head;  // sentinel node as pseudo-head
	  public MyLinkedList() {
	    size = 0;
	    head = new ListNode(0);
	  }

	  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	  public int get(int index) {
	    // if index is invalid
	    if (index < 0 || index >= size) return -1;

	    ListNode curr = head;
	    // index steps needed 
	    // to move from sentinel node to wanted index
	    for(int i = 0; i < index + 1; ++i) {
	    	curr = curr.next;

	    }
	    return curr.val;
	  }

	  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	  public void addAtHead(int val) {
	    addAtIndex(0, val);
	  }

	  /** Append a node of value val to the last element of the linked list. */
	  public void addAtTail(int val) {
	    addAtIndex(size, val);
	  }

	  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	  public void addAtIndex(int index, int val) {
	    // If index is greater than the length, 
	    // the node will not be inserted.
	    if (index > size) return;

	    // [so weird] If index is negative, 
	    // the node will be inserted at the head of the list.
	    if (index < 0) index = 0;

	    ++size;
	    // find predecessor of the node to be added
	    ListNode pred = head;
	    for(int i = 0; i < index; ++i) pred = pred.next;

	    // node to be added
	    ListNode toAdd = new ListNode(val);
	    // insertion itself
	    toAdd.next = pred.next;
	    pred.next = toAdd;
	  }

	  /** Delete the index-th node in the linked list, if the index is valid. */
	  public void deleteAtIndex(int index) {
	    // if the index is invalid, do nothing
	    if (index < 0 || index >= size) return;

	    size--;
	    // find predecessor of the node to be deleted
	    ListNode pred = head;
	    for(int i = 0; i < index; ++i) pred = pred.next;

	    // delete pred.next 
	    pred.next = pred.next.next;
	  }
	}

///*public class MyLinkedList {
//	
//	LNode head = null;
//
//	public static void main(String[] args) {
//
//	}
//	
//	
//	/** Initialize your data structure here. */
//    public MyLinkedList() {
//
//    }
//    
//    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
//    public int get(int index) {
//
//    	LNode current = head;
//    	int data = 0;
//    	int i=-1;
//    	while(current !=null) {
//    		if(i == index) {
//    			data=  current.val;
//    			break;
//    		}
//    		current = current.next;
//    		i++;
//    	}
//        
//    
//    	
//		return data;
//        
//    }
//    
//    
//    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
//    public void addAtHead(int val) {
//    	
//    	LNode nodeToAdd = new LNode(val);
//        if(head == null) {
//        	head = nodeToAdd;
//        } else {
//        	nodeToAdd.next= head;
//        	head = nodeToAdd;
//        }
//    }
//    
//    /** Append a node of value val to the last element of the linked list. */
//    public void addAtTail(int val) {
//    	
//    	LNode current = head;
//    	LNode nodeToAdd = new LNode(val);
//    	while(current.next !=null) {
//    		current = current.next;
//    	}
//        
//    	current.next = nodeToAdd;
//        
//    }
//    
//    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
//    public void addAtIndex(int index, int val) {
//    	LNode current = head;
//    	LNode prev = null;
//    	LNode nodeToAdd = new LNode(val);
//
//    	int i=-1;
//    	while(current !=null) {
//    		if(i == index) {
//    			if(prev != null) {
//    				prev.next=nodeToAdd;
//    				nodeToAdd.next=current;
//    			} else {
//    				nodeToAdd.next= head;
//    	        	head = nodeToAdd;
//    			}
//    		}
//    		prev = current;
//    		current = current.next;
//    		i++;
//    	}
//        
//    }
//    
//    /** Delete the index-th node in the linked list, if the index is valid. */
//    public void deleteAtIndex(int index) {
//
//    	LNode current = head;
//    	LNode prev = null;
//
//    	int i=-1;
//    	while(current !=null) {
//    		if(i == index) {
//    			if(prev != null) {
//    				prev.next=current.next;
//    			} else {
//    				head= head.next;
//    			}
//    		}
//    		prev = current;
//    		current = current.next;
//    		i++;
//    	}
//        
//    }
//    
//    class LNode{
//    	int val;
//    	LNode next;
//    	
//    	public LNode(int val) {
//    		this.val = val;
//    	}
//    }
//   
//} */




/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */