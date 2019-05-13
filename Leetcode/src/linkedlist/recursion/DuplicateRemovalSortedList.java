package linkedlist.recursion;

import classes.ListNode;

public class DuplicateRemovalSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(8);
		head.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next.next = new ListNode(6);
		ListNode res = deleteDuplicates(head);
		printList(res);
	}
	private static void printList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print("->"+temp.val);
			temp = temp.next;
		}
		
	}
	public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;
        head = helper(head, head.next);
        return head;
    }
    
    public static ListNode helper(ListNode head, ListNode n){
        if(n == null) return head;
        if(head.val == n.val){
            return n;
        }
        return helper(n, n.next);
    }
}
