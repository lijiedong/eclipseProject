package com.dlj.stack.getMin;

public class GetMinStackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack1 myStack1 = new MyStack1();
		int[] arr = { 3, 4, 5, 1, 2, 1 };
		for (int i = 0; i < arr.length; i++) {
			myStack1.push(arr[i]);
			System.out.print("The value to be pushed into the stack is:" + myStack1.peek());
			System.out.println("The min value of the stack is:" + myStack1.getMin());
		}
		System.out.println("--------------");
		MyStack1 myStack2 = new MyStack1();

		for (int i = 0; i < arr.length; i++) {
			myStack2.push(arr[i]);
			System.out.print("The value to be pushed into the stack is:" + myStack2.peek());
			System.out.println("The min value of the stack is:" + myStack2.getMin());
		}
	}

}
