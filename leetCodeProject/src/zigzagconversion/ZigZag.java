package zigzagconversion;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

public class ZigZag {
	@Test
	public void test() {
		String str = convert("PAYPALISHIRING", 4);
		st1();
	}

	public void t1() {
		System.out.println(-6 % 7);
	}

	public String convert(String s, int numRows) {
		LinkedList[] list = new LinkedList[numRows];
		for (int i = 0; i < numRows; i++) {
			list[i] = new LinkedList<Character>();
		}
		int length = 0;
		while (length < s.length()) {
			for (int i = 0; i < numRows && length < s.length(); i++) {
				list[i].add(s.charAt(length++));
			}

			for (int i = numRows - 2; i > 0 && length < s.length(); i--) {
				list[i].add(s.charAt(length++));
			}

		}
		for (int i = 1; i < numRows; i++) {
			int size = list[i].size();
			for (int j = 0; j < size; j++) {
				list[0].add(list[i].remove());
			}
		}
		String str = list[0].toString();
		return str.substring(1, str.length() - 1).replaceAll(", ", "");
	}

	public void st1() {
		String str = "  hi  world  ~  ";
		System.out.println(str.length());
		// 方法1：str.trim()
		System.out.println("1--->" + str.trim());
		// 方法2：str.repalce(" ","")
		System.out.println("2--->" + str.replace(" ", ""));
		// 方法3：str.repalceAll(" ","")
		System.out.println("3--->" + str.replaceAll(" ", ""));
		// 方法4：str.repalceAll(" +","")
		System.out.println("4--->" + str.replaceAll(" +", ""));
		// 方法5：str.repalceAll("\\s*","")
		System.out.println("4--->" + str.replaceAll("\\s*", ""));
	}

	public String convert3(String s, int numRows) {
		boolean flagDown = true;
		Stack[] stack = new Stack[numRows];
		for (int i = 0; i < numRows; i++) {
			stack[i] = new Stack<Character>();
		}
		int length = 0;
		while (length < s.length()) {
			for (int i = 0; i < numRows && length < s.length(); i++) {
				stack[i].push(s.charAt(length++));
			}

			for (int i = numRows - 2; i > 0 && length < s.length(); i--) {
				stack[i].push(s.charAt(length++));
			}

		}
		StringBuilder str = new StringBuilder();
		char[] chars = new char[s.length()];
		int len = 0;
		for (int i = 0; i < numRows; i++) {
			Stack<Character> tempStack = new Stack<Character>();
			int size = stack[i].size();
			for (int j = 0; j < size; j++) {
				tempStack.push((Character) stack[i].pop());
			}
			for (int j = 0; j < size; j++) {
				chars[len++] = tempStack.pop();
			}
		}

		return String.valueOf(chars);
	}

	public String convert1(String s, int numRows) {

		int flagy = 0;
		boolean flagDown = true;
		Stack[] stack = new Stack[numRows];
		for (int i = 0; i < numRows; i++) {
			stack[i] = new Stack<Character>();
		}
		for (int i = 0; i < s.length(); i++) {
			if (numRows == 1) {
				stack[flagy].push(s.charAt(i));
			} else if (numRows == 2) {
				if (flagDown) {
					stack[flagy].push(s.charAt(i));
					flagy++;
					if (flagy == numRows) {
						flagDown = false;
					}
				} else {

				}
			} else {
				if (flagDown) {
					stack[flagy].push(s.charAt(i));
					flagy++;
					if (flagy == numRows) {
						flagDown = false;
					}
				} else {
					if (flagy == numRows) {
						flagy -= 2;
					}
					stack[flagy].push(s.charAt(i));
					if (flagy == 1 && numRows != 2) {
						flagDown = true;

					}
					if (numRows == 2) {
						flagDown = true;
						flagy++;
					} else if (numRows != 2) {
						flagy--;
					}

				}
			}
		}

		char[] chars = new char[s.length()];
		StringBuilder str = new StringBuilder();

		int len = 0;
		for (int i = 0; i < numRows; i++) {
			Stack<Character> tempStack = new Stack<Character>();
			int size = stack[i].size();

			for (int j = 0; j < size; j++) {
				tempStack.push((Character) stack[i].pop());
			}
			for (int j = 0; j < size; j++) {
				System.out.println(tempStack.peek());
				str.append(tempStack.pop());
			}
		}
		return str.toString();
	}

	public String converts(String s, int numRows) {
		// Stack<Character>[] stack = new Stack<Character>[numRows];
		// 首先创建一个数组栈
		Stack[] stack = new Stack[numRows];
		for (int i = 0; i < numRows; i++) {
			stack[i] = new Stack<Character>();
		}
		// 声明两个变量用来判断是向下走还是向前走
		int flagy = 0;
		int length = 0;
		while (length < s.length()) {
			if (flagy < numRows) {
				for (int i = 0; i < numRows && length < s.length(); i++) {
					stack[i].push(s.charAt(length++));
				}
				flagy = numRows;
			} else if (numRows == flagy) {
				for (int i = numRows - 2; i > 0 && length < s.length(); i--) {
					stack[i].push(s.charAt(length++));
				}
				flagy = 0;
			}
		}

		char[] chs = new char[s.length()];
		int index = 0;
		for (int i = 0; i < numRows; i++) {
			if (!stack[i].isEmpty()) {
				Stack<Character> tempStack = new Stack<Character>();
				for (int j = 0; j < stack[i].size(); j++) {
					char ch = (char) stack[i].pop();
					System.out.println(ch);
					tempStack.push(ch);
				}
				for (int j = 0; j < tempStack.size(); j++) {
					chs[index++] = tempStack.pop();

				}
			}
		}
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i]);
		}
		return chs.toString();
	}
}
/*
 * for (int i = 0; i < s.length(); i++) { if (flagDown) {
 * arrs[flagy][arr[flagy]] = s.charAt(i); arr[flagy]++; flagy++; if (flagy ==
 * numRows) { flagDown = false; }
 * 
 * } else { arrs[flagy][arr[flagy]++] = s.charAt(i); flagy--; if (flagy == 0) {
 * flagDown = true; } }
 * 
 * }
 */