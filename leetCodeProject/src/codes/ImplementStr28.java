package codes;

public class ImplementStr28 {
	// 该算法是找出给定一个字串在字符串中出现的位置
	public int strStr(String haystack, String needle) {
		if (needle.equals("") || needle == null) {
			return 0;
		}
		int i = 0, j = 0, k = i;// 分别用来表示字符串的下标，子串的下标，以及存储遍历过程中位置
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				j = 0;
				i = ++k;
			}
		}
		if (j == needle.length()) {
			return k;
		} else {
			return -1;
		}

	}

	public int search(String haystack, String needle) {
		int N = haystack.length();
		int M = needle.length();
		for (int i = 0; i <= N - M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
				if (j == M) {
					return i;
				}
			}
		}
		return 0;
	}
}
