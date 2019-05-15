package palindromeNumber;

import java.util.Stack;

import org.junit.Test;

public class PalindromeNumber {
	@Test
	public void test() {

	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else {

			String str = Integer.toString(x);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					return false;

				}

			}
			return true;
		}
	}

	public boolean isPalindromes(int x) {
		if (x < 0) {
			return false;
		} else {
			boolean flag = true;
			String str = Integer.toString(x);
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
			}
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != stack.pop()) {
					flag = false;
					break;
				}
			}
			return flag;
		}
	}
}
