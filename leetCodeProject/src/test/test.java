package test;

import java.util.ArrayList;

import org.junit.Test;

public class test {
	@Test
	public void test() {
		t1();
	}

	public void t1() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		ArrayList<Integer> arrs = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
			arrs.add(arr.get(i));
		}
		System.out.println("-----");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arrs.get(i));

		}
	}
}
