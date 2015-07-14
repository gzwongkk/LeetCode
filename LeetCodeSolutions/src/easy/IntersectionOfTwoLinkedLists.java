package easy;

import java.util.HashSet;

import util.ListNode;

public class IntersectionOfTwoLinkedLists {

	/**
	 * Write a program to find the node at which the intersection of two singly linked lists begins.
	 * For example, the following two linked lists:
	 * A:		a1 -> a2 
	 * 					  -> c1 -> c2 -> c3
	 * B: b1 -> b2 -> b3
	 * begin to intersect at node c1.
	 * Notes:
	 * 		If the two linked lists have no intersection at all, return null.
	 * 		The linked lists must retain their original structure after the function returns.
	 * 		You may assume there are no cycles anywhere in the entire linked structure.
	 * 		Your code should preferably run in O(n) time and use only O(1) memory.
	 **/
	public static void main(String[] args) {
		ListNode[] list = ListNode.ListNodeArray(0,10);
		System.out.println(getIntersectionNode(list[0], list[5]));
	}

	/*
	 * 1) two pointers: O(m+n)time O(1)space.
	 * 2) two pointers clever trick: Traverse a list then redirect to another. This gives two pointers
	 * 				at exactly the same pace, which is equivalent to the first solution.
	 * 3) hash table: O(m+n)time O(m)space.
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if( headA == null || headB == null ) return null;
		int countA = 0, countB = 0;
		for( ListNode a = headA; a != null; a = a.next, ++countA );
		for( ListNode b = headB; b != null; b = b.next, ++countB );

		int size = Math.min(countA, countB);
		for(int i = 0; i < countA-size; ++i, headA = headA.next);
		for(int i = 0; i < countB-size; ++i, headB = headB.next);

		while( headA != headB ){
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	public static ListNode getIntesectionNodeTrick(ListNode headA, ListNode headB){
		if( headA == null || headB == null ) return null;
		ListNode a = headA, b = headB;
		boolean isAFirstIteration = true, isBFirstIteration = true;
		while( true ){
			if( a == b ) return a;
			a = a.next;
			b = b.next;
			if( a == null && isAFirstIteration){
				a = headB;
				isAFirstIteration = false;
			}
			if( b == null && isBFirstIteration ){
				b = headA;
				isBFirstIteration = false;
			}
		}
	}

	public static ListNode getIntersectionNodeHash(ListNode headA, ListNode headB){
		HashSet<Integer> table = new HashSet<Integer>();
		while( headA != null ){
			table.add(headA.hashCode());
			headA = headA.next;
		}
		while( headB != null ){
			if( table.contains(headB.hashCode())) return headB;
			headB= headB.next;
		}
		return null;
	}
}
