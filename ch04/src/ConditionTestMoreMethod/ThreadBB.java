package ConditionTestMoreMethod;

public class ThreadBB extends Thread {
	private MyService service;

	public ThreadBB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.methodB();
	}
	
}
