package wait_notify_size5;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Object lock=new Object();
			ThreadA a=new ThreadA(lock);
			a.start();
			ThreadB b=new ThreadB(lock);
			b.start();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
