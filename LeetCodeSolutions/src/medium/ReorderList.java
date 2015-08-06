package medium;

import util.ListNode;

public class ReorderList {

	/**
	 * Given a singly linked list L: L0 -> L1 -> ... -> Ln-1 -> Ln,
	 * reorder it to: L0 -> Ln -> L1 -> Ln-1 -> ...
	 * You must do this in-place without altering the nodes' values. 
	 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 **/
	public static void main(String[] args) {
		ListNode[] node = ListNode.ListNodeArray(1, 4);
		reorderList(node[0]);
		System.out.println(node[0]);
		ListNode[] node2 = ListNode.ListNodeArray(1, 10);
		reorderList(node2[0]);
		System.out.println(node2[0]);
	}

	/*
	 * OJ system is out of its mind. It only accepts three variables or otherwise call MLE.
	 * Find the mid-point of the list, then reverse the second half, and insert the reversed
	 * list into the first half.
	 */
	public static void reorderList(ListNode head){
		if( head == null ) return;
		ListNode slow = head, fast = head, cur = null;
		while( fast.next != null ){
			fast = fast.next.next == null? fast.next: fast.next.next;
			slow = slow.next;
		}
		
		cur = slow.next;
		slow.next = null;
		fast = null;
		while( cur != null ){
			slow = cur.next;
			cur.next = fast;
			fast = cur;
			cur = slow;
		}
		
		slow = head;
		while( fast != null ){
			cur = fast.next;
			fast.next = slow.next;
			slow.next = fast;
			slow = fast.next;
			fast = cur;
		}
	}
}
