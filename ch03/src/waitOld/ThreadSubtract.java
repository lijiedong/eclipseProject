package waitOld;

public class ThreadSubtract extends Thread {
	private Subtract r;

	public ThreadSubtract(Subtract r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		r.subtract();
	}
	
}
