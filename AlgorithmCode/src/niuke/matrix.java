package niuke;

import java.util.Stack;

import org.junit.Test;

public class matrix {
	@Test
	public void test() {
		push(3);
		System.out.println(min());
	}

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int node) {
		stack.push(node);
		if (minStack.isEmpty()) {
			minStack.push(node);
		} else {
			if (node > minStack.peek()) {
				minStack.push(minStack.peek());
			}
		}
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return minStack.peek();
	}
}
