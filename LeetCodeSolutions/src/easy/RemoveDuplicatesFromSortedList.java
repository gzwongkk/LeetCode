package easy;

import util.ListNode;

public class RemoveDuplicatesFromSortedList {

	/**
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once. For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 **/
	public static void main( String[] args ) {
		ListNode[] list = ListNode.ListNodeArray( 0, 10 );
		for ( int i = 0; i < list.length-1; i++ )
			list[i].next = new ListNode(i, list[i+1]);
		System.out.println(list[0]);
		System.out.println(deleteDuplicates( list[0] ));
	}
	
	/*
	 * Both methods are okay. I did some garbage collection thing, but not sure if
	 * it is necessary.
	 */
	public static ListNode deleteDuplicates(ListNode head){
		if( head == null ) return null;
		ListNode prev = head, cur = head.next;
		while( cur != null ){
			if( cur.val == prev.val ){
				prev.next = cur.next;
				cur.next = null;
				cur = prev.next;
			} else {
				prev = prev.next;
				cur = cur.next;
			}
		}
		return head;
	}
	
	public static ListNode deleteDuplicatesRecursive(ListNode head){
		/*
		if( head == null || head.next == null ) return head;
		head.next = deleteDuplicatesRecursive( head.next );
		return head.val == head.next.val ? head.next : head;
		*/
		return head != null && (head.next = deleteDuplicatesRecursive(head.next)) != null 
				&& head.val == head.next.val? head.next: head;
	}
}
