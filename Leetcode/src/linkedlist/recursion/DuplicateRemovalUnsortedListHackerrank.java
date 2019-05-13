package linkedlist.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import classes.ListNode;

public class DuplicateRemovalUnsortedListHackerrank {

	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(2);
		
		/*head.next = new ListNode(3);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next.next = new ListNode(6);*/
		ListNode res = deleteDuplicates(head);
		printList(res);
	}
	private static ListNode deleteDuplicates(ListNode head) {
		ListNode start = head;
		ListNode prev = null;
		Map<Integer, ListNode> map = new HashMap<>();
		while(null != head) {
			if(!map.containsKey(head.val)) {
				map.put(head.val, head);
				prev = head;
				head = head.next;
			}else {
				head = head.next;
				prev.next = head;
			}
		}
 		return start;
	}
	private static void printList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print("->"+temp.val);
			temp = temp.next;
		}
		
	}
	
	
	
	
	
	
	/*public static ListNode deleteDuplicates(ListNode head) {
		Map<Integer, ListNode> map = new LinkedHashMap<>();
		ListNode start = null;
		while(head != null) {
			if(!map.containsKey(head.val)) {
				map.put(head.val, new ListNode(head.val));
			}
			head = head.next;
		}
		List<ListNode> list = new ArrayList<>(map.values());
		for (int i = 0; i < list.size(); i++) {
			if(i == 0) {
				start = list.get(i);
				continue;
			}
			ListNode temp = list.get(i-1);
			temp.next = list.get(i);
			if(i == list.size()) {
				temp.next.next = null;
			}
		}
		return start;
    }*/
    
    
}
