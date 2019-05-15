package test2;

public class MyThread1 extends Thread {
	private Object lock;

	public MyThread1(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
			try {
				
				synchronized(lock){
				System.out.println("开始 wait time="+System.currentTimeMillis()+Thread.currentThread().getName());
				lock.wait();
				System.out.println("结束 wait time="+System.currentTimeMillis()+Thread.currentThread().getName());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
