package t7;

public class MyThread2 extends Thread {
	private Task task;

	public MyThread2(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	
		task.doLongTimeTask();

	}
	
}
