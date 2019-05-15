package ConditionTest;

public class ThreadB extends Thread {
	private MyService myService;

	

	public ThreadB(MyService myService) {
		super();
		this.myService = myService;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			myService.get();
		}
	}
	 
}
