package easy;

import java.util.Stack;

public class MinStack {

	/**
	 * Design a stack that supports push, pop, top, and
	 * retrieving the minimum element in constant time.
	 **/

	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(5);
		s.push(15);
		s.push(2);
		System.out.println(""+s.top()+"\t"+s.getMin());
		s.pop();
		System.out.println(""+s.top()+"\t"+s.getMin());
		s.pop();
		System.out.println(""+s.top()+"\t"+s.getMin());
		s.pop();
		System.out.println(""+s.top()+"\t"+s.getMin());
		s.pop();
		System.out.println(""+s.top()+"\t"+s.getMin());
		s.pop();
		System.out.println(""+s.top()+"\t"+s.getMin());
		s.pop();
		System.out.println(""+s.top()+"\t"+s.getMin());
		s.pop();
		System.out.println(""+s.top()+"\t"+s.getMin());
	}

	/*
	 * To have a min value stored, using the property of stack, it can 
	 * act as an element so that it creates some sort of window or level.
	 * push min if a new minimum reached, pop it and get it back when it
	 * is popped back, thus popping twice is required.
	 * Was trying not to use library stack but memory limit exceeded.
	 */

	private Stack<Integer> ms = new Stack<Integer>();;
	private int min = Integer.MAX_VALUE;

	public void push(int x){
		if( x <= min ){
			ms.push(min);
			min = x;
		}
		ms.push(x);
	}

	public void pop(){
		if(ms.isEmpty())
			return;
		if(ms.peek()==min){
			ms.pop();
			min=ms.pop();
		}else{
			ms.pop();
		}
	}

	public int top(){
		return ms.isEmpty()?0:ms.peek();
	}

	public int getMin(){
		return min;
	}
}
