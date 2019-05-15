package UseConditionWaitNotifyError;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	public void await(){
		try{
			lock.lock();
			condition.await();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
