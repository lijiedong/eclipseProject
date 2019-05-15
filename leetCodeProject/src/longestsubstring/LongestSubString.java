package longestsubstring;

import org.junit.Test;

public class LongestSubString {
	@Test
	public void test() {
		int length = lengthOfLongestSubstring(" ");
		System.out.println(length);

	}

	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		char[] chars = s.toCharArray();

		for (int j = 0; j < chars.length; j++) {
			int len = 0;
			int[] arrs = new int[256];
			for (int i = j; i < chars.length; i++) {
				// 先获取字符的ASCII码
				int ch = chars[i];

				if (arrs[ch] != 1) {
					arrs[ch] = 1;
					len++;
				} else {
					break;
				}

			}
			if (maxLength < len) {
				maxLength = len;
			}
		}

		return maxLength;
	}

	public int lengthOfLongestSubstrings(String s) {
		int maxLength = 0;
		char[] chars = s.toCharArray();

		for (int j = 0; j < chars.length; j++) {
			int len = 0;
			int[] arrs = new int[52];
			for (int i = j; i < chars.length; i++) {
				// 先获取字符的ASCII码
				int ch = chars[i];

				if (ch >= 97 && ch <= 122) {// 如果是小写字母
					if (arrs[chars[i] - 97] != 1) {
						arrs[chars[i] - 97] = 1;
						len++;
					} else {
						break;
					}
				} else if (ch >= 65 && ch <= 90) {// 如果是大写字母
					if (arrs[chars[i] - 39] != 1) {// 这里实际上是-65+26，因为要把大写的字符对应到数组的后一半
						arrs[chars[i] - 39] = 1;
						len++;
					} else {
						break;
					}
				} else {// 当字符不是字母的时候
					break;
				}

			}
			if (maxLength < len) {
				maxLength = len;
			}
		}

		return maxLength;
	}

}
