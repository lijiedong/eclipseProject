package testComparator;

import java.util.Comparator;

public class myComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return p2.age - p1.age;
	}

}
