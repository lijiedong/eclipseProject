package t6;

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
		CommonUtils.beginTime2=System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime2=System.currentTimeMillis();
	}
	
}