package util;

public class ListNode {
	public ListNode(int x) { val = x; }
	
	public ListNode(int x, ListNode n) { 
		val = x;
		next = n;
	}
	
	public static ListNode[] ListNodeArray(int startingVal, int num){
		ListNode[] list = new ListNode[num];
		for( int i = 0; i < list.length; ++i )
			list[i] = new ListNode(startingVal + i);
		for( int i = 0; i < list.length-1; ++i )
			list[i].next = list[i+1];
		return list;
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		ListNode node = this, cycle = detectCycle(node);
		boolean runIntoCycle = false;
		while( node != null ){
			if( node == cycle ){
				if( runIntoCycle ){
					output.append("} Tail of cycle");
					break;
				} else {
					output.append("{ ");
					runIntoCycle = true;
				}
			}
			output.append(node.val+" ");
			node = node.next;
		}
		return output.toString();
	}
	
	//Implemented in medium.LinkedListCycleII.java
	public ListNode detectCycle(ListNode head){
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
	
	public int val;
	public ListNode next;
}
