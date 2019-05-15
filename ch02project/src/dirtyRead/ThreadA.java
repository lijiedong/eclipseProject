package dirtyRead;

public class ThreadA extends Thread {
	private PublicVar publicVar;

	public ThreadA(PublicVar publicVar) {
		super();
		this.publicVar = publicVar;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		publicVar.setValue("B","BB");
	}
	
	
}
