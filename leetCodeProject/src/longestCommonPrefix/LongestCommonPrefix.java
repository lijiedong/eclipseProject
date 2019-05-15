package longestCommonPrefix;

import org.junit.Test;

public class LongestCommonPrefix {
	@Test
	public void test() {
		// String[] strs = { "flower", "flow", "flight" };
		String[] strs = { "", "a" };
		System.out.println(longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1) {
			return "";
		}

		int len = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			if (len > strs[i].length()) {
				len = strs[i].length();
			}
		}
		int temp = len;
		for (int i = 0; i < strs.length - 1; i++) {
			int max = 0;
			for (int j = 0; j < temp; j++) {
				if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
					max++;
				} else {

					break;
				}
			}
			if (max < len) {
				len = max;
			}
		}
		/*
		 * if (len == 0) { // return new String(chars, 0, len); return ""; }
		 * else { return strs[0].substring(0, len); }
		 */
		return strs[0].substring(0, len);
	}
}
