package twostackqueue;

import java.util.Stack;

public class TwoStackQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;

	public TwoStackQueue() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}

	// 入队列
	public void add(int x) {
		stackPush.push(x);
	}

	// 出队列
	public int poll() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("the Queue is empty!");
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}

	public int peek() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("the Queue is empty!");
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}

}
