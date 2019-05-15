package t13_1;

public class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("run begin");
		
		
		try {
			Thread.sleep(1000);
			System.out.println("run end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("在沉睡中被停止！进入catch"+this.isInterrupted()+Thread.currentThread().getId());
			e.printStackTrace();
		}
		
	}
	

}
