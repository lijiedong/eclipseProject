package reverseInteger;

import org.junit.Test;

public class ReverseInteger {
	@Test
	public void test() {
		System.out.println(reverse(-2147483648));
		System.out.println(-1 / 10);
	}

	public int reverse(int x) {
		if (x < 0) {
			long l = x % 10;
			x /= 10;
			while (x < 0) {
				l = l * 10 + x % 10;
				x /= 10;
			}
			if (l < -2147483648) {
				return 0;
			} else {
				return (int) l;
			}

			/*
			 * int temp = x; long b = (long) 0 - x; long l = b % 10; b = b / 10;
			 * while (b > 0) { l = l * 10 + b % 10; b = b / 10; } l = 0 - l; if
			 * (l < -2147483648) { return 0; } else { return (int) l; }
			 */
		} else {
			long l = x % 10;
			x = x / 10;
			while (x > 0) {
				l = l * 10 + x % 10;
				x /= 10;
			}
			if (l > 2147483647) {
				return 0;
			} else {
				return (int) l;
			}
			/*
			 * String str = Integer.toString(x); long l =
			 * Integer.parseInt(Character.toString(str.charAt(str.length() -
			 * 1))); for (int i = str.length() - 2; i >= 0; i--) { l = l * 10 +
			 * Integer.parseInt(Character.toString(str.charAt(i))); } if (l >
			 * 2147483647) { return 0; } else { return (int) l; }
			 */

		}

	}
}
/*
 * float y = x; String str = new
 * StringBuilder(Integer.toString(x)).reverse().toString(); if (x < 0) { y =
 * Float.parseFloat(str.substring(0, str.length() - 1));
 * 
 * } else { y = Float.parseFloat(str.substring(0, str.length())); }
 * 
 * if (y > Math.pow(2, 31) - 1 || y < -Math.pow(2, 31)) { x = 0; } else { if (x
 * > 0) { x = Integer.parseInt(str.substring(0, str.length())); } else if (x <
 * 0) { x = -Integer.parseInt(str.substring(0, str.length() - 1)); } else { x =
 * 0; }
 * 
 * }
 */