package waitOld;

public class ThreadAdd extends Thread {
	private Add p;

	public ThreadAdd(Add p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		p.add();
	}
	
}
