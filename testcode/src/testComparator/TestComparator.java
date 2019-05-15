package testComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparator {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(12));
		list.add(new Person(9));
		list.add(new Person(10));
		list.add(new Person(22));
		System.out.println("排序前：");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).age + "  ");
		}
		System.out.println("\n" + "排序后：");
		/*
		 * Collections.sort(list); for (int i = 0; i < list.size(); i++) {
		 * System.out.print(list.get(i).age + "  "); }
		 */
		System.out.println("\n" + "使用自定义比较器排序后：");
		Collections.sort(list, new myComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).age + "  ");
		}
		Person p1 = new Person(12);
		Person p2 = new Person(13);
		System.out.println(p1.compareTo(p2));
	}
}
