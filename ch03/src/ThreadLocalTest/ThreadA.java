package ThreadLocalTest;

public class ThreadA extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for(int i=0;i<100;i++){
				Tools.tl.set("ThreadA "+(i+1));
				System.out.println("ThreadA get Value="+Tools.tl.get());;
				Thread.sleep(200);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
