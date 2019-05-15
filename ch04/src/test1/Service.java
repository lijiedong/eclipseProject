package test1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
	public ReentrantLock lock=new ReentrantLock();
	public Condition condition=lock.newCondition();
	public void waitMethod(){
		
		try {
			if(lock.tryLock(3,TimeUnit.SECONDS)){
				System.out.println(Thread.currentThread().getName()+"获得锁时间"+System.currentTimeMillis());
				Thread.sleep(10000);
			}else{
				System.out.println(Thread.currentThread().getName()+"没有获得锁");
			}
		
			
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("释放锁"+Thread.currentThread().getName());
			lock.unlock();
		}
	}

}
