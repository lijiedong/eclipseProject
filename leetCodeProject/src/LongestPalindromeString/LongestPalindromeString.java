package LongestPalindromeString;

import org.junit.Test;

public class LongestPalindromeString {
	@Test
	public void test() {
		String str = longestPalindrome("aacdefcaa");
		System.out.println(str);

	}

	private int maxLen = 0;
	String str = "";

	// 该算法是用来求一个字符串的最长回文字符串子串
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}

		for (int i = 0; i < s.length(); i++) {
			findLongestPalindrome(s, i, i);
			findLongestPalindrome(s, i, i + 1);
		}
		return str;
	}

	public void findLongestPalindrome(String s, int low, int high) {
		while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
		}

		if (high - low - 1 > maxLen) {
			maxLen = high - low - 1;
			str = s.substring(low + 1, high);
		}

	}
}
