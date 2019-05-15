package ConditionTestMoreMethod;

public class ThreadAA extends Thread {
	private MyService service;

	public ThreadAA(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service.methodA();
	}
	
}
