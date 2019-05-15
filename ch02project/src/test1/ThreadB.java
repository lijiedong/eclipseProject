package test1;

public class ThreadB extends Thread {
	private Service service;
	private MyObject object;
	public ThreadB(Service service, MyObject object) {
		super();
		this.service = service;
		this.object = object;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		//service.testMethod1(object);
		//service.test();
		object.speedPrintString();
	}
	
}
