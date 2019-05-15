package t7;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task=new Task();
		MyThread1 thread1=new MyThread1(task);
		thread1.setName("thread1");
		thread1.start();
		MyThread2 thread2=new MyThread2(task);
		thread2.setName("thread2");
		thread2.start();
	}

}
