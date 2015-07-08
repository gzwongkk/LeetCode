package easy;

import util.ListNode;

public class MergeTwoSortedLists {

	/**
	 * Merge two sorted linked lists and return it as a new list.
	 * The new list should be made by splicing together the nodes of the first two lists.
	 */
	public static void main(String[] args) {
		ListNode[] list1 = new ListNode[5];
		ListNode[] list2 = new ListNode[5];
		for( int i = 0; i < list1.length; ++i ){
			list1[i] = new ListNode(i*2);
			list2[i] = new ListNode(i*4+1);
		}
		for( int i = 0; i < list1.length-1; ++i ){
			list1[i].next = list1[i+1];
			list2[i].next = list2[i+1];
		}
		System.out.println(list1[0]);
		System.out.println(list2[0]);
		System.out.println(mergeTwoLists(list1[0], list2[0]));
	}

	/*
	 * Like the merge process in merge sort.
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode head = new ListNode(0), cur = head;
		while( l1 != null && l2 != null ){
			if( l1.val > l2.val ){
				cur.next = l2;
				l2 = l2.next;
			} else {
				cur.next = l1;
				l1 = l1.next;
			}
			cur = cur.next;
		}
		if( l1 != null ) cur.next = l1;
		if( l2 != null ) cur.next = l2;
		return head.next;
	}
}
