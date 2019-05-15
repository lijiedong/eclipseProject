package MustUseMoreCondition_OK;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock=new ReentrantLock();
	public Condition conditionA=lock.newCondition();
	public Condition conditionB=lock.newCondition();
	public void awaitA(){
		try {
			lock.lock();
			System.out.println("begin awaitA时间为："+System.currentTimeMillis()+
					" threadName="+Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end awaitA时间为："+System.currentTimeMillis()+
					" threadName="+Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void awaitB(){
		try {
			lock.lock();
			System.out.println("begin awaitA时间为："+System.currentTimeMillis()+
					" threadName="+Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end awaitA时间为："+System.currentTimeMillis()+
					" threadName="+Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void signalAll_A(){
		try{
			lock.lock();
			System.out.println("signalAll_A时间为"+System.currentTimeMillis()+" threadNmae="+
			 Thread.currentThread().getName());
		}finally{
			lock.unlock();
		}
	}
	public void signalAll_B(){
		try{
			lock.lock();
			System.out.println("signalAll_B时间为"+System.currentTimeMillis()+" threadNmae="+
			 Thread.currentThread().getName());
		}finally{
			lock.unlock();
		}
	}
}
