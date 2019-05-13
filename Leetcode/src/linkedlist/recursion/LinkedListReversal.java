package linkedlist.recursion;
import classes.ListNode;


public class LinkedListReversal {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		reverseList(l1);
	}
	 public static ListNode reverseList(ListNode head) {
	        ListNode curr = head;
	        ListNode prev = null;
	        while(curr != null) {
	        	ListNode next = curr.next;
	        	curr.next = prev;
	        	prev = curr;
	        	curr = next;
	        }
	        return prev;
	    }
}


