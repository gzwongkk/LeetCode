package easy;

import util.ListNode;

public class SwapNodesInPairs {
	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * Your algorithm should use only constant space. You may not modify the values in th list, only nodes itself can be changed.
	 **/
	public static void main(String[] args) {
		ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.println(list);
		System.out.println(swapPairs(list));
	}

	/*
	 * The use of dummy node can eliminate special cases.
	 */
	public static ListNode swapPairs(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		head = dummy;
		ListNode first, second;
		while ( head.next != null && head.next.next != null ) {
			first = head.next;
			second = head.next.next;
			head.next = second;
			first.next = second.next;
			second.next = first;
			head = second.next;
		}
		
		return dummy.next;
	}
}
