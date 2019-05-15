package stack_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class MyStack {
	private List list=new ArrayList();
	synchronized public void push(){
		try {
			if(list.size()>=1){
				System.out.println("waiting---"+Thread.currentThread().getName());
				this.wait();
			}
			list.add("anyString="+Math.random());
			this.notifyAll();
			System.out.println("push="+list.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized public String pop(){
		String returnValue="";
		try {
			
			while(list.size()==0){
				System.out.println("pop操作中的："+Thread.currentThread()
				.getName()+"线程处于wait状态");
				this.wait();
			}
			returnValue=""+list.get(0);
			list.remove(0);
			this.notifyAll();
			System.out.println("pop="+list.size()+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

}
