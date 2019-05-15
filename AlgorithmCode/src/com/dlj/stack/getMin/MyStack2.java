package com.dlj.stack.getMin;

import java.util.Stack;

public class MyStack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public MyStack2() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		// 先判断元素是否需要压入stackMmin，最后一步总是将元素压入要stackData中
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		} else if (newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		} else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}

	public int pop() {

		if (this.stackData.isEmpty()) {

			throw new RuntimeException("the stack is empty now！");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}

	public int getMin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("the stack is empty now！");
		}
		return this.stackMin.peek();
	}

	public int peek() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("the stack is empty now！");
		}
		return this.stackData.peek();
	}
}
