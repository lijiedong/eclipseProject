package p_c_allWait;

public class ThreadC extends Thread {
	private C r;

	public ThreadC(C r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			r.getValue();
		}
	}
	
}
