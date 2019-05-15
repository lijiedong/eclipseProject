package codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*返回电话号码的字母组合*/
public class LetterCombinationsOfAPhoneNumber17 {
	@Test
	public void test() {
		String str = "23";
		List<String> lists = letterCombinations(str);
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}
		System.out.println("".length());
	}

	public List<String> letterCombinations(String digits) {
		// 首先判断字符串是否为空
		if (digits == null || digits.length() == 0) {
			return new ArrayList<String>();
		}
		String[] strs = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		Map<Integer, String> map = new HashMap<>();
		// 先将第一个数字所对应的字母给放进去
		int number = digits.charAt(0) - '0';
		if (number >= 2 && number <= 6 || number == 8) {
			map.put(0, strs[number - 2].charAt(0) + "");
			map.put(1, strs[number - 2].charAt(1) + "");
			map.put(2, strs[number - 2].charAt(2) + "");
		} else {
			map.put(0, strs[number - 2].charAt(0) + "");
			map.put(1, strs[number - 2].charAt(1) + "");
			map.put(2, strs[number - 2].charAt(2) + "");
			map.put(3, strs[number - 2].charAt(3) + "");
		}

		for (int i = 1; i < digits.length(); i++) {
			Map<Integer, String> tempMap = map;
			map = new HashMap<Integer, String>();
			number = digits.charAt(i) - '0';
			int temp = 0;// 用来标识新的map的下表
			if (number >= 2 && number <= 6 || number == 8) {

				for (int j = 0; j < tempMap.size(); j++) {
					String tempStr = tempMap.get(j);
					map.put(temp++, tempStr + strs[number - 2].charAt(0));
					map.put(temp++, tempStr + strs[number - 2].charAt(1));
					map.put(temp++, tempStr + strs[number - 2].charAt(2));
				}
			} else {

				for (int j = 0; j < tempMap.size(); j++) {
					String tempStr = tempMap.get(j);
					map.put(temp++, tempStr + strs[number - 2].charAt(0));
					map.put(temp++, tempStr + strs[number - 2].charAt(1));
					map.put(temp++, tempStr + strs[number - 2].charAt(2));
					map.put(temp++, tempStr + strs[number - 2].charAt(3));
				}
			}
		}
		List<String> lists = new ArrayList<>();
		for (int i = 0; i < map.size(); i++) {
			lists.add(map.get(i));
		}

		return lists;
	}
}
