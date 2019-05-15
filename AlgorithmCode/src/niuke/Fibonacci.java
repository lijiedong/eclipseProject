package niuke;

import org.junit.Test;

/*该算法实现了斐波那契数列*/
public class Fibonacci {
	@Test
	public void test() {
		System.out.println(Integer.toBinaryString(0));
		for (int i = 1; i < 10; i++) {
			System.out.print(sum(i) + "--");
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			System.out.print(sum2(i) + "--");
		}
	}

	public int sum(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return sum(n - 1) + sum(n - 2);
		}
	}

	// 数列是从第0项开始的，0 1 1 2 3 5 8 13 21 ...
	public int sum2(int n) {
		if (n <= 2 && n > 0) {
			return 1;
		} else {
			int first = 1;
			int second = 1;
			int result = 0;
			for (int i = 3; i <= n; i++) {
				result = first + second;
				first = second;
				second = result;
			}
			return result;
		}
	}

	/*
	 * 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。 2）n = 1时，只有1种跳法，f(1) = 1 3) n =
	 * 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)  4) n =
	 * 3时，会有三种跳得方式，1阶、2阶、3阶，
	 *     那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3     因此结论是f(3)
	 * = f(3-1)+f(3-2)+f(3-3) 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：     f(n) =
	 * f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ...
	 * + f(n-1)    6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：     f(n-1) = f(0) +
	 * f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... +
	 * f(n-2)     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) =
	 * f(n-1) + f(n-1)     可以得出：     f(n) = 2*f(n-1)
	 */
	public int JumpFloorII(int target) {
		if (target == 1) {
			return 1;
		} else if (target == 2) {
			return 2;
		} else {
			return 2 * JumpFloorII(target - 1);
		}
	}

	public int NumberOf1(int n) {
		String str = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

}
