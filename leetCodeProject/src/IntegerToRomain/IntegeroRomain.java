package IntegerToRomain;

import org.junit.Test;

public class IntegeroRomain {
	@Test
	public void test() {
		System.out.println(intToRoman(400));
	}

	/**
	 * 这道题的思路就是依次转换千百十个位的数字， 其中千位的最简单，有几千就加几个M
	 * 但是百位就不同了，有可能是900多，也有可能是500多到899，以及400到499，100到399， 所以各种情况都要考虑到，
	 * 同样的还有10位，各位，其中各位就这几个数，所以懒得再用判断了，直接一个switch语句解决问题。
	 */

	public String intToRoman(int num) {
		int number = 0;
		String str = "";
		// 当大于1000的时候
		// 转换千位
		if (num >= 1000) {
			number = num / 1000;
			for (int i = 0; i < number; i++) {
				str += "M";
			}
			num = num - number * 1000;
		}
		// 转换百位
		if (num >= 900) {
			str += "CM";
			num -= 900;
		} else if (num >= 500) {
			str += "D";
			num -= 500;
			number = num / 100;
			for (int i = 0; i < number; i++) {
				str += "C";
			}
			num = num - number * 100;
		} else if (num >= 400) {
			str += "CD";
			num -= 400;
		} else if (num >= 100) {
			number = num / 100;
			for (int i = 0; i < number; i++) {
				str += "C";
			}
			num = num - number * 100;
		}
		// 转换十位
		if (num >= 90) {
			str += "XC";
			num = num - 90;
		} else if (num >= 50) {
			str += "L";
			num -= 50;
			number = num / 10;
			for (int i = 0; i < number; i++) {
				str += "X";
			}
			num = num - number * 10;
		} else if (num >= 40) {
			str += "XL";
			num -= 40;
		} else if (num >= 10) {
			number = num / 10;
			for (int i = 0; i < number; i++) {
				str += "X";
			}
			num = num - number * 10;
		}
		// 转换个位
		switch (num) {
		case 9:
			str += "IX";
			break;
		case 8:
			str += "VIII";
			break;
		case 7:
			str += "VII";
			break;
		case 6:
			str += "VI";
			break;
		case 5:
			str += "V";
			break;
		case 4:
			str += "IV";
			break;
		case 3:
			str += "III";
			break;
		case 2:
			str += "II";
			break;
		case 1:
			str += "I";
			break;
		default:
			break;

		}

		return str;
	}
}
