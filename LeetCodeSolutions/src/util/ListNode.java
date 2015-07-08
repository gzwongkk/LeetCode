package util;

public class ListNode {
	public ListNode(int x) { val = x; }
	public ListNode(int x, ListNode n) { 
		val = x;
		next = n;
	}
	@Override
	public String toString(){
		String s = "";
		ListNode temp = this;
		while( temp != null ){
			s += temp.val+" ";
			temp = temp.next;
		}
		return s;
	}
	
	public int val;
	public ListNode next;
}
