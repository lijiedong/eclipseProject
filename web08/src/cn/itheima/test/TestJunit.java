package cn.itheima.test;

import org.junit.Before;
import org.junit.Test;

public class TestJunit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("aaa");
	}
	@Test
	public void testJunit(){
		System.out.println("Hello Junit!");
	}
	@Before
	public void testBefore(){
		System.out.println("before!");
	}
}
