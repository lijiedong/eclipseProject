package t1;

public class ThreadB extends Thread {
	private HaseSelfPrivateNum numRef;

	public ThreadB(HaseSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		numRef.addI("b");
	}
	
	
}

