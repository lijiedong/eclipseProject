package t11;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			MyThread thread=new MyThread();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
