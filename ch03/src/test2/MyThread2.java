package test2;

public class MyThread2 extends Thread {
	private Object lock;

	public MyThread2(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized(lock){
			System.out.println("开始 notify time="+System.currentTimeMillis());
			lock.notifyAll();
			System.out.println("结束 notify time="+System.currentTimeMillis());
		}

			}
	
}
