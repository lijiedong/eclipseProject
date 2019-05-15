package romanToInteger;

import org.junit.Test;

public class RomanToInteger {
	@Test
	public void test() {
		System.out.println(romanToInt("MCMXCIV"));
	}

	public int romanToInt(String s) {
		byte len = 0;
		short sum = 0;
		while (len < s.length()) {
			if (s.charAt(len) == 'M') {
				sum += 1000;
				len = (byte) (len + 1);
			} else if (s.charAt(len) == 'D') {
				sum += 500;
				len = (byte) (len + 1);
			} else if (s.charAt(len) == 'C') {
				if (len + 1 < s.length()) {
					if (s.charAt(len + 1) == 'D') {
						sum += 400;
						len = (byte) (len + 2);

					} else if (s.charAt(len + 1) == 'M') {
						sum += 900;
						len = (byte) (len + 2);
					} else {
						sum += 100;
						len = (byte) (len + 1);
					}
				} else {
					sum += 100;
					len = (byte) (len + 1);
				}

			} else if (s.charAt(len) == 'L') {
				sum += 50;
				len = (byte) (len + 1);
			} else if (s.charAt(len) == 'X') {
				if (len + 1 < s.length()) {
					if (s.charAt(len + 1) == 'L') {
						sum += 40;
						len = (byte) (len + 2);
					} else if (s.charAt(len + 1) == 'C') {
						sum += 90;
						len = (byte) (len + 2);
					} else {
						sum += 10;
						len = (byte) (len + 1);
					}
				} else {
					sum += 10;
					len = (byte) (len + 1);
				}

			} else if (s.charAt(len) == 'V') {
				sum += 5;
				len = (byte) (len + 1);
			} else if (s.charAt(len) == 'I') {
				if (len + 1 < s.length()) {
					if (s.charAt(len + 1) == 'V') {
						sum += 4;
						len = (byte) (len + 2);
					} else if (s.charAt(len + 1) == 'X') {
						sum += 9;
						len = (byte) (len + 2);
					} else {
						sum += 1;
						len = (byte) (len + 1);
					}
				} else {
					sum += 1;
					len = (byte) (len + 1);
				}
			}
		}
		return sum;
	}
}
