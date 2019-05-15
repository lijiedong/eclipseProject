package toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int m = sc.nextInt();
		solv(str, m);
	}

	public static void solv(String s, int m) {
		Map<Character, List> map = new HashMap<>(26);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			List list = map.get(c);
			if (list == null)
				map.put(c, list = new ArrayList<Integer>(100));
			list.add(i);
		}
		int maxLen = 1;
		for (Map.Entry<Character, List> entry : map.entrySet()) {
			List<Integer> arrayList = entry.getValue();
			for (int i = 0; i < arrayList.size(); i++) {
				int ctr = arrayList.get(i);
				int[] move = new int[arrayList.size()];
				// 获取 move[]，表示每个相同字母到中心点 ctr 需要移动的最少步数
				for (int j = 0; j < arrayList.size(); j++)
					move[j] = (Math.abs(arrayList.get(j) - ctr) - Math.abs(i - j));
				// 排序后，选择移动代价最少的前 k + 1 个
				Arrays.sort(move);
				int sum = 0;
				for (int k = 0; k < move.length; k++) {
					sum += move[k];
					if (sum > m)
						break;
					if (k + 1 > maxLen)
						maxLen = k + 1;
				}
			}
		}
		System.out.println(maxLen);
	}
}
