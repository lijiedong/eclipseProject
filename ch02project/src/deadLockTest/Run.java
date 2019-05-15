package deadLockTest;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DealThread t1=new DealThread();
			t1.setFlag("a");
			Thread th1=new Thread(t1);
			th1.start();
			Thread.sleep(100);
			t1.setFlag("b");
			Thread t2=new Thread(t1);
			t2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
