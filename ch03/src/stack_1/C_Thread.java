package stack_1;

public class C_Thread extends Thread {
	private C r;

	public C_Thread(C r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			r.popService();
		}
	}
	
}
