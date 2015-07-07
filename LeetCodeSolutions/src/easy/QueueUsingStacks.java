package easy;

import java.util.Stack;

public class QueueUsingStacks {

	/**
	 * Implement the following operations of a queue using stacks.
	 * push(x)	-- Push element x to the back of queue.
	 * pop()	-- Removes the element in front of queue.
	 * peek()	-- Get the front element.
	 * empty()	-- Return whether the queue is empty.
	 * Notes:
	 * 		You must use only standard operations of a stack -- which means only
	 * 			push to top, peek/pop from top, size, and is empty operations are valid.
	 * 		Depending on your language, stack may not be supported natively. You may
	 * 			simulate a stack by using a list or deque, as long as you use only standard
	 * 			operations of a stack.
	 * 		Your may assume that all operations are valid ( for example, no pop or peek
	 * 			operations will be called on an empty queue).
	 */
	
	public static void main(String[] args) {
		QueueUsingStacks myQueue = new QueueUsingStacks();
	}
	
	/*
	 * negative times a negative is a positive!
	 * pushing a stack into another stack makes it a queue!
	 */
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> queue = new Stack<Integer>();
	
	private void organize(){
		while( !stack.isEmpty() )
			queue.push(stack.pop());
	}
	
	public void push(int x){
		stack.push(x);
	}
	
	public void pop(){
		if(queue.isEmpty())	organize();
		queue.pop();
	}
	
	public int peek(){
		if(queue.isEmpty())	organize();
		return queue.peek();
	}
	
	public boolean empty(){
		return stack.isEmpty()&&queue.isEmpty();
	}
}
