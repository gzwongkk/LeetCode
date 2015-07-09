package easy;

import util.ListNode;

public class RemoveNthNodeFromEnd {

	/**
	 * Given a linked list, remove the nth node from the end of list
	 * and return its head. For example,
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * After removing the second node from the end, the linked list becomes 1->2->3->5.
	 * 
	 * Note:
	 * Given n will always be valid.
	 * Try to do this in one pass.
	 */
	
	public static void main(String[] args) {
		ListNode[] list = new ListNode[5];
		for(int i = 0; i < list.length; ++i)
			list[i] = new ListNode(i);
		for(int i = 0; i < list.length-1; ++i)
			list[i].next = list[i+1];
		System.out.println(list[0]);
		
		int input = 2;
		System.out.println(removeNthFromEnd(list[0], input));
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n){
		ListNode dummy = new ListNode(0), prev = dummy, cur = head;
		dummy.next = head;
		for( int i = 1; i < n ; ++i )
			cur = cur.next;
		while( cur.next != null ){
			prev = prev.next;
			cur = cur.next;
		}
		cur = prev.next;
		prev.next = cur.next;
		cur.next = null;
		return dummy.next;
	}
}
