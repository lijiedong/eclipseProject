package p_c_allWait;

public class ThreadP extends Thread {
	private P p;

	public ThreadP(P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			p.setValue();
		}
	}
	
}