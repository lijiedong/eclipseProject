package p_r_test;

public class ThredC extends Thread {
	private C r;

	public ThredC(C r) {
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
