package easy;

import util.ListNode;

public class ReverseLinkedList {

	/**
	 * Reverse a singly linked list
	 **/

	public static void main(String[] args) {
		ListNode[] list = new ListNode[10];
		for( int i = 0; i < 10; ++i)
			list[i] = new ListNode(i);
		for( int i = 0; i < 9; ++i)
			list[i].next = list[i+1];
		System.out.println(list[0]);
		System.out.println(reverseList(list[0]));
	}

	public static ListNode reverseList(ListNode head){
		ListNode prev = null, cur = head, next = null;
		while( cur != null ){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
