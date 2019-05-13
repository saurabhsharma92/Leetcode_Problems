package linkedlist.recursion;

import classes.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists
 * Input: 1->2->4, 1->3->4
   Output: 1->1->2->3->4->4
 */
public class MergeSortedList {
	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(4);
		ListNode nodeB = new ListNode(1);
		nodeB.next = new ListNode(3);
		nodeB.next.next = new ListNode(4);
		ListNode result = mergeTwoLists(nodeA, nodeB);
		while(null != result) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(null == l1);
		ListNode result = l1;
	       //while(null != l1 && null != l1.next && null != l2 && l1.val <= l2.val && l1.next.val > l2.val){
		while(null != l1 && null != l2 && l1.val <= l2.val){
	           ListNode temp = l1.next;
	           l1.next = l2;
	           l2 = l2.next;
	           l1.next.next = temp;
	           l1 = l1.next.next;
	       }
	        return result;
	    }
}
