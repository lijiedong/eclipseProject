package atomicIntegerNoSafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MyService {
	public static AtomicInteger aiRef=new AtomicInteger();
	synchronized public void addNum(){
		System.out.println(Thread.currentThread().getName()+
				"加了100之后的值是："+aiRef.addAndGet(100));
		aiRef.addAndGet(1);
	}
}
