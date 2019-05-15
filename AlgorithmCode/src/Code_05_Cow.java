public class Code_05_Cow {

	public static int cowNumber1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return cowNumber1(n - 1) + cowNumber1(n - 3);
	}

	public static int cowNumber2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int res = 3;
		int pre = 2;
		int prepre = 1;
		int tmp1 = 0;
		int tmp2 = 0;
		for (int i = 4; i <= n; i++) {
			tmp1 = res;
			tmp2 = pre;
			res = res + prepre;
			pre = tmp1;
			prepre = tmp2;
		}
		return res;
	}

	public static int cowNumber3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int res3 = 1, res2 = 2, res1 = 3, res = 0;
		for (int i = 4; i <= n; i++) {
			res = res1 + res3;
			res3 = res2;
			res2 = res1;
			res1 = res;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 5;
		for (int i = 1; i <= 15; i++) {
			System.out.println("第" + i + "年：" + cowNumber1(i));
		}

		// System.out.println(cowNumber3(n));

	}
}