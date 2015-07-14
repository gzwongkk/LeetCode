package easy;

import util.ListNode;

public class PalindromeLinkedList {

	/**
	 * Given a singly linked list, determine if it is a palindrome.
	 **/
	public static void main(String[] args) {
		ListNode[] list = new ListNode[11];
		for( int i = 0; i < list.length; ++i )
			list[i] = new ListNode(Math.abs(5-i));
		for( int i = 0; i < list.length-1; ++i )
			list[i].next = list[i+1];
		System.out.println(list[0]);
		System.out.println(isPalindrome(list[0]));
		System.out.println(list[0]);

		ListNode[] list2 = new ListNode[10];
		for( int i = 0; i < list2.length; ++i )
			list2[i] = i < list2.length/2?new ListNode(i):new ListNode(list2.length-i-1);
		for( int i = 0; i < list2.length-1; ++i )
			list2[i].next = list2[i+1];
		System.out.println(list2[0]);
		System.out.println(isPalindrome(list2[0]));
		System.out.println(list2[0]);
		
		ListNode[] list3 = new ListNode[10];
		for( int i = 0; i < list3.length; ++i )
			list3[i] = new ListNode(Math.abs(5-i));
		for( int i = 0; i < list3.length-1; ++i )
			list3[i].next = list3[i+1];
		System.out.println(list3[0]);
		System.out.println(isPalindrome(list3[0]));
		System.out.println(list3[0]);
	}

	/*
	 * An O(n) time O(1) space method. Special divide method in linked list and then reverse
	 * the second half. Voila, c'est facile quoi. Don't forget to reverse back just to get a good habit.
	 */
	public static boolean isPalindrome(ListNode head){
		if( head == null || head.next == null ) return true;
		ListNode front = head, middle = head, middleNext, last = head.next;
		while( last.next != null ){
			middle = middle.next;
			last = last.next;
			if( last.next != null )
				last = last.next; 
		}
		middleNext = reverseList(middle.next);
		while(last != null){
			if( front.val != last.val ){
				reverseList(middleNext);
				return false;
			}
			front = front.next;
			last = last.next;
		}
		reverseList(middleNext);
		return true;
	}
	
	public static ListNode reverseList(ListNode head){
		ListNode prev = null, cur = head, next = null;
		while( cur != null ){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
