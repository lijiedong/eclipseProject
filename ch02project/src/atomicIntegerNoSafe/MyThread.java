package atomicIntegerNoSafe;

public class MyThread extends Thread {
	private MyService service;

	public MyThread(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.addNum();
	}
	
}
