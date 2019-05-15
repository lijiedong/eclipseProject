package t1;

public class ThreadA extends Thread {
	private HaseSelfPrivateNum numRef;

	public ThreadA(HaseSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		numRef.addI("a");
	}
	
	
}
