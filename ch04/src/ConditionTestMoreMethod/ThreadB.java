package ConditionTestMoreMethod;

public class ThreadB extends Thread {
	private MyService service;

	public ThreadB(MyService service) {
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
