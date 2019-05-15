package codes;

import java.util.Stack;

import org.junit.Test;

public class ValidParenttheses20 {
	@Test
	public void test() {
		System.out.println(isValid("{[]}"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == '}') {
				if (!stack.isEmpty() && stack.pop() == '{') {

				} else {
					return false;
				}
			} else if (s.charAt(i) == ')') {
				if (!stack.isEmpty() && stack.pop() == '(') {

				} else {
					return false;
				}
			} else if (s.charAt(i) == ']') {
				if (!stack.isEmpty() && stack.pop() == '[') {

				} else {
					return false;
				}
			}

		}
		if (!stack.isEmpty()) {
			return false;
		} else {
			return true;

		}
	}
}
