package generic;

public class Pair<U, V> {
	U first;
	V second;

	public Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
}
