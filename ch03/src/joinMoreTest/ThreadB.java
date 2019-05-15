package joinMoreTest;

public class ThreadB extends Thread {

	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			System.out.println("begin B threadName="+
		Thread.currentThread().getName()+" "+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(" end B ThreadName="+
			Thread.currentThread().getName()+" "+
					System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
