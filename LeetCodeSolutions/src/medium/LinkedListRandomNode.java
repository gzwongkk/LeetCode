package medium;

import util.ListNode;

public class LinkedListRandomNode {
	/**
	 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same 
	 * probability of being chosen.
	 * 
	 * What if the linked list is extremely large and its length is unknown to you?
	 * Could you solve this efficiently without using extra space? 
	 **/
	public static void main(String[] args) {

	}

	/*
	 * Count the node list to obtain the size of data set, then we can apply uniform distribution to obtain one node.
	 * It takes 2 passes. If only one pass is allowed, refer to reservoir sampling.
	 */
	public ListNode head;
	
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
	}
	
	public int getRandom() {
		ListNode target = head;
		int n = 1;
		while( target.next != null ) {
			target = target.next;
			n++;
		}
		
		target = head;
		for ( int t = (int) (Math.random()*n); t != 0; --t, target = target.next );
		return target.val;
	}
	
	public int getRandomReservoir() {
		ListNode target = head;
		int n = 1, ans = head.val;
		
		while ( target.next != null ) {
			target = target.next;
			if ( Math.random() < 1.0/(n++) )
				ans = target.val;
		}
		
		return ans;
	}
}
