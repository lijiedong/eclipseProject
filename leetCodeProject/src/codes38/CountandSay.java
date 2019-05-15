package codes38;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

/**
 * 该算法按照顺序对整数进行报数
 *
 */
public class CountandSay {
	@Test
	public void test() {

		System.out.println(countAndSay(5));
	}

	public void t1(String str) {
		str = "";

	}

	public String countAndSay(int n) {
		String str = "1";
		for (int i = 0; i < n - 1; i++) {
			str = solution2(str);
		}
		return str;
	}

	public String solution2(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			} // 这个while循环我确实没有想到，它在里面，还可以进行i++的运算，只能说太妙了
			sb.append(count);
			sb.append(str.charAt(i));
		}

		return sb.toString();
	}

	public String solution1(String str) {
		String tempStr = "";
		int i = 0;
		char ch = str.charAt(i++);
		int count = 1;
		while (true) {
			if (i >= str.length()) {
				break;
			} else {
				char tempChar = str.charAt(i++);
				if (tempChar == ch) {
					count++;
				} else {
					tempStr += count;
					tempStr += ch;
					count = 1;
					ch = tempChar;
				}
			}
		}
		tempStr += count;
		tempStr += ch;
		return tempStr;
	}

	public String solution(String str) {
		Map<Character, Integer> map = new HashMap<>();
		String temp = str;
		str = "";
		for (int i = 0; i < temp.length(); i++) {
			Integer count = map.get(temp.charAt(i));
			if (count != null) {
				map.put(temp.charAt(i), ++count);
			} else {
				Iterator<Character> iter = map.keySet().iterator();
				while (iter.hasNext()) {
					Character ch = iter.next();
					str += map.get(ch);
					str += ch;
					// 清空map
					map.clear();
				}

				map.put(temp.charAt(i), 1);
			}

		} // 不能忘记最后一个数
		Iterator<Character> iter = map.keySet().iterator();
		Character ch = iter.next();
		str += map.get(ch);
		str += ch;
		// 清空map
		map.clear();
		return str;
	}
}
