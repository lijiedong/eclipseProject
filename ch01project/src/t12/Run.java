package t12;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread=new MyThread();
		thread.start();
		try {
			Thread.sleep(1000);
			thread.interrupt();
			System.out.println("ÊÇ·ñÍ£Ö¹1:"+thread.interrupted());
			System.out.println("ÊÇ·ñÍ£Ö¹2£º"+thread.isInterrupted());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
