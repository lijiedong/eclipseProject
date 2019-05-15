package com.dlj.stack.getMin;

import java.util.Stack;

public class MyStack1 {
	/*
	 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回值的栈中最小元素的操作 要求pop、push、getMin操作的时间复杂度都是O(1)
	 * 实现思路，在设计上我们使用两个栈，一个栈用来保存当前栈中的元素，这个栈记
	 * 为stackData，另一个栈用于保存每一步的最小值，这个栈几位stackMin 具体的实现方式有两种 第一种： 压入数据规则：
	 * 假设当前数据为newNum，先将其压入stackData，然后判断stackMin是否为空
	 * 如果为空newStack，则newNum也压入stackMin，如果不为空，则比较newNum和stackMin的栈顶元素哪个更小
	 * 如果newNum更小或者两者相等，则newNum也压入stackMin，否则不压入任何内容 弹出规则：
	 * 设弹出的元素记为value，如果value比stackMin中栈顶元素相等时，stackMin弹出元素，
	 * 如果value大于stackMin中的元素则不弹出
	 */
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public MyStack1() {
		stackData = new Stack<Integer>();
		stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		// 先判断元素是否需要压入stackMmin，最后一步总是将元素压入要stackData中
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		} else if (newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}

	public int pop() {

		if (this.stackData.isEmpty()) {

			throw new RuntimeException("the stack is empty now！");
		}
		int value = this.stackData.pop();
		if (value == this.getMin()) {
			this.stackMin.pop();
		}
		return value;
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
