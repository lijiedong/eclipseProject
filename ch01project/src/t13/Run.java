package t13;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread=new MyThread();
		thread.start();
		try {
			thread.sleep(200);
			thread.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end!");
		
	}

}
