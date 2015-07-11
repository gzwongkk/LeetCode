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
