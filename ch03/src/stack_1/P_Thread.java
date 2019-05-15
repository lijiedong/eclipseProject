package stack_1;

public class P_Thread extends Thread {
	private P p;

	public P_Thread(P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			p.pushService();
		}
	}
	
	
}
