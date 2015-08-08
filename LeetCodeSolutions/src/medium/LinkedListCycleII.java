package medium;

import java.util.HashSet;

import util.ListNode;

public class LinkedListCycleII {

	/**
	 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	 * Follow up: Can you solve it without using extra space?
	 **/
	public static void main(String[] args) {
		ListNode[] node = ListNode.ListNodeArray(0, 10);
		System.out.println(detectCycle(node[0]));
		node[9].next = node[5];
		System.out.println(node[0]);
		ListNode head = detectCycle(node[0]);
		System.out.println(head);
	}

	/*
	 * Same as LinkedListCycle, but be aware that the Floyd's cycle-finding algorithm is not terminating at starting point.
	 * Let the cycle length be m and the list length be x, k is the distance from starting point to the node they met.
	 * Then, slow pointer traveled = (x-m) + k and fast pointer traveled = (x-m) + k + n*m. Since fast pointer runs twice
	 * faster than slow, fast = 2 * slow = 2 * ( (x-m) + k ) => (x-m) + k = n*m ==> (x-m) = (n-1)*m + (m-k)
	 * This states that if the pointer move another k steps, it would become (m-k+k) % m = 0 ==> starting point.
	 */
	public static ListNode detectCycle(ListNode head){
		if( head == null ) return null;
		ListNode slow = head, fast = head;
		while( true ){
			slow = slow.next;
			try { fast = fast.next.next; } 
			catch (NullPointerException e) { return null; }
			if( slow == fast ) break;
		}
		slow = head;
		while( slow != fast ){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static ListNode detectCycleHash(ListNode head){
		HashSet<ListNode> appeared = new HashSet<ListNode>();
		while( head != null ){
			if( appeared.contains(head) ) return head;
			else{
				appeared.add(head);
				head = head.next;
			}
		}
		return null;
	}
}
