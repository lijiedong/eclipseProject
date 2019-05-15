package suspend_resume_test;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread=new MyThread();
		thread.start();
		try {
			Thread.sleep(5000);
			thread.suspend();
			System.out.println("A="+System.currentTimeMillis()+"i="+thread.getI());
			Thread.sleep(5000);
			System.out.println("A="+System.currentTimeMillis()+"i="+thread.getI());
			thread.resume();
			Thread.sleep(5000);
			thread.suspend();
			System.out.println("B="+System.currentTimeMillis()+"i="+thread.getI());
			Thread.sleep(5000);
			System.out.println("B="+System.currentTimeMillis()+"i="+thread.getI());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
