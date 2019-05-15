package TwoThreadTransData;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	private List list=new ArrayList();
	public void add(){
		list.add("高洪岩");
		System.out.println("gaga");
	}
	public int size(){
		return list.size();
	}
}
