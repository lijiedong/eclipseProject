package stringToInteger;

import org.junit.Test;

public class StringToInteger {
	@Test
	public void test() {
		System.out.println(myAtoi("42"));
	}

	public int myAtoi(String str) {
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		} else {
			long temp = 0;
			int len = 0;
			boolean flag = false;// 标志着是否为负
			if (str.charAt(len) == '+') {
				len++;
			} else if (str.charAt(len) == '-') {
				len++;
				flag = true;
			}
			while (len < str.length()) {
				if (str.charAt(len) >= '0' && str.charAt(len) <= '9') {
					temp = temp * 10 + str.charAt(len) - '0';
					len++;
					if (temp > Integer.MAX_VALUE) {
						temp = Integer.MAX_VALUE;
					}
				} else {
					break;
				}
			}
			if (flag) {
				temp = 0 - temp;
				if (temp < Integer.MIN_VALUE) {
					temp = Integer.MIN_VALUE;
				}
			}

			return (int) temp;

		}

	}

	public int myAtoi2(String str) {
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		} else {
			if (str.charAt(0) == '+') {
				if (str.length() == 1) {
					return 0;
				} else {// 字符串长度大于等于2时，需要看是否第二个字符是不是数字
					if (str.charAt(1) < 48 || str.charAt(1) > 57) {
						return 0;
					} else {
						byte len = 1;
						long temp = 0;
						while (len < str.length() && str.charAt(len) >= 48 && str.charAt(len) <= 57) {
							temp = temp * 10 + Integer.parseInt(Character.toString(str.charAt(len++)));
							if (temp > Integer.MAX_VALUE) {
								return Integer.MAX_VALUE;
							}
						}
						return (int) temp;

					}

				}

			} else if (str.charAt(0) == '-') {
				if (str.length() == 1) {
					return 0;
				} else {
					if (str.charAt(1) < 48 || str.charAt(1) > 57) {
						return 0;
					} else {
						byte len = 1;
						long temp = 0;
						while (len < str.length() && str.charAt(len) >= 48 && str.charAt(len) <= 57) {
							temp = temp * 10 - Integer.parseInt(Character.toString(str.charAt(len++)));
							if (temp < Integer.MIN_VALUE) {
								return Integer.MIN_VALUE;
							}
						}
						return (int) temp;
					}
				}

			} else if (str.charAt(0) >= 48 && str.charAt(0) <= 57) {
				byte len = 0;
				long temp = 0;
				while (len < str.length() && str.charAt(len) >= 48 && str.charAt(len) <= 57) {
					temp = temp * 10 + Integer.parseInt(Character.toString(str.charAt(len++)));
					if (temp > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				}
				return (int) temp;

			} else {
				return 0;
			}
		}
	}

	public int myAtois(String str) {
		str = str.trim();
		if (str.length() == 0) {// 字符串长度为0的时候
			return 0;
		} else if (str.length() == 1) {// 字符串长度为1的时候
			if (str.charAt(0) < 48 || str.charAt(0) > 57) {
				return 0;
			} else {
				return Integer.parseInt(str);
			}
		} else {// 字符串长度大于等于2
			// 先判断第一个字符是不是除了+-和数字意外的负号
			if (str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) < 48 || str.charAt(0) > 57)) {
				return 0;
			} else {// 第一个字符不是除了+-和数字意外的负号,同时也要先判断一下
				if ((str.charAt(0) < 48 || str.charAt(0) > 57) && (str.charAt(1) < 48 || str.charAt(1) > 57)) {
					return 0;
				} else {
					// 到了这里就默认第一个字符要么是数字，要么是正号，要么是负号
					int len = 0;
					// 遍历字符串
					// 先找到第一个负号或者数字字符
					while (len < str.length() && (str.charAt(len) < 48 || str.charAt(len) > 57)) {
						len++;
					}
					// 找到第一个数字字符后，判断它的前面那个字符是不是负号字符,前提是len不是在字符串的最首位
					int temp = 0;
					int flag = 1;// 用来表示要转换的数是负数还是正数
					if (len != 0) {
						if (str.charAt(len - 1) == '-') {
							flag = -1;
						}
					}
					while (len < str.length() && (str.charAt(len) >= 48 && str.charAt(len) <= 57)) {
						temp = temp * 10 + Integer.parseInt(Character.toString(str.charAt(len++)));
					}

					// 判断转换后的数据是否越界
					if (flag == 1) {
						if (temp > 2147483647) {
							return 2147483647;
						} else {
							return (int) temp;
						}
					} else {
						temp = temp * flag;
						if (temp < -2147483648) {
							return -2147483648;
						} else {
							return (int) temp;
						}
					}

				}
			}

		}

	}
}
