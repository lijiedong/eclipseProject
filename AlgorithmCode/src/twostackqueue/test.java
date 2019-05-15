package twostackqueue;

public class test {
	public static void main(String[] args) {
		TwoStackQueue queue = new TwoStackQueue();
		for (int i = 0; i < 10; i++) {
			queue.add(i);
		}
		System.out.println(queue.peek());
	}
}
