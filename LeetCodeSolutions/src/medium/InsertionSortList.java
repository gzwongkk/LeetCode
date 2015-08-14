package medium;

import util.ListNode;

public class InsertionSortList {

	/**
	 * Sort a linked list using insertion sort.
	 **/
	public static void main(String[] args) {
		System.out.println(insertionSortList(ListNode.ListNodeArray(1, 10)[0]));
	}

	/*
	 * Remember that insertion sort is stable, so the comparison method is defined.
	 */
	public static ListNode insertionSortList(ListNode head){
		if( head == null || head.next == null ) return head;
		ListNode begin = new ListNode(0), node = begin, cur = head, next;
		while( cur != null ){
			node = ( node == null || node.next == null || node.next.val >= node.val )? begin: node;
			while( node.next != null && node.next.val < cur.val ) node = node.next;
			next = cur.next;
			cur.next = node.next;
			node.next = cur;
			cur = next;
		}
		return begin.next;
	}
}
