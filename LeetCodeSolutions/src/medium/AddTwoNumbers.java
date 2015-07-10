package medium;

import util.ListNode;

public class AddTwoNumbers {
	
	/**
	 * You are given two linked lists representing two non-negative
	 * numbers. The digits are stored in reverse order and each of
	 * their nodes contain a single digit. Add the two numbers and
	 * return it as a linked list.
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 **/
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);
		l1.next = l12;
		l12.next = l13;
		l2.next = l22;
		l22.next = l23;
		
		ListNode answer = addTwoNumbers(l1, l2);
		while(answer != null){
			System.out.print(answer.val);
			answer=answer.next;
		}
	}

	/*
	 * As in Computer Organization, the key of doing addition is to apply 
	 * the concept of carryIn as in ALU. O(m+n) in Time and Space.
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode answer = new ListNode(0), current = answer;
		int sum = 0;
		while( l1!=null || l2!=null || sum != 0 ){
			if( l1 != null ){
				sum+=l1.val;
				l1 = l1.next;
			}
			if( l2 != null ){
				sum+=l2.val;
				l2 = l2.next;
			}
			current.next = new ListNode(sum%10);
			sum /= 10;
			current = current.next;
		}
		return answer.next;
	}
}
