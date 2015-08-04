package medium;

import util.ListNode;

public class RotateList {

	/**
	 * Given a list, rotate the list to the right by k places, where k is non-negative.
	 * For example, 
	 * Given 1->2->3->4->5->NULL and k = 2,
	 * return 4->5->1->2->3->NULL.
	 **/
	public static void main(String[] args) {
		ListNode[] head = ListNode.ListNodeArray(1, 5);
		System.out.println(rotateRight(head[0], 2));
	}

	/*
	 * Using the fast slow pointer technique, together with a special case which saves some time
	 * when over-length shifts occurred. Setting i = -1 is because the for loop will add one to it.
	 */
	public static ListNode rotateRight(ListNode head, int k){
		if( head == null || head.next == null ) return head;
		ListNode fast = head, slow = head, shiftHead = head;
		for( int i = 0; i < k; ++i )
			if( fast.next == null ){
				fast = head;
				k %= (i+1);
				i = -1;
			} else fast = fast.next;
		if( k == 0 ) return head;

		while( fast.next != null ){
			slow = slow.next;
			fast = fast.next;
		}
		shiftHead = slow.next;
		slow.next = null;
		fast.next = head;
		return shiftHead;
	}
}
