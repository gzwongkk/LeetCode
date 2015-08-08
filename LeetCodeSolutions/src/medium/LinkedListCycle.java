package medium;

import java.util.HashSet;

import util.ListNode;

public class LinkedListCycle {

	/**
	 * Given a linked list,m determine if it has a cycle in it. 
	 * Follow up: Can you solve it without using extra space?
	 **/
	public static void main(String[] args) {
		ListNode[] node = ListNode.ListNodeArray(1, 10);
		System.out.println(hasCycle(node[0]));
		node[9].next = node[0];
		System.out.println(hasCycle(node[0]));
	}

	/*
	 * If a linked list has a cycle, a faster pace pointer must catch a slow pace pointer, given unlimited time. 
	 * O(n) space solution is strict forward which simply use a HashSet to check duplicates, and should be much
	 * slower in practice, since hashing is not guaranteed to be O(1). The runtime of Floyd's cycle-finding algorithm
	 * is also not guaranteed though...
	 */
	public static boolean hasCycle(ListNode head){
		if( head == null ) return false;
		ListNode slow = head, fast = head;
		while( true ){
			slow = slow.next;
			try { fast = fast.next.next; } 
			catch (NullPointerException e) { return false; }
			if( slow == fast ) return true;
		}
	}
	
	public static boolean hasCycleHash(ListNode head){
		HashSet<ListNode> appeared = new HashSet<ListNode>();
		while( head != null ){
			if( appeared.contains(head) ) return true;
			else{
				appeared.add(head);
				head = head.next;
			}
		}
		return false;
	}
}
