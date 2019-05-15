package test2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			Object lock=new Object();
			MyThread1 t1=new MyThread1(lock);
			t1.setName("t1");
			t1.start();
			MyThread1 t3=new MyThread1(lock);
			t3.setName("t3");
			t3.start();
			Thread.sleep(3000);
			MyThread2 t2=new MyThread2(lock);
			t2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
