package t13_1;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread=new MyThread();
		thread.start();
//	thread.sleep(10);
		thread.interrupt();

	}

}
