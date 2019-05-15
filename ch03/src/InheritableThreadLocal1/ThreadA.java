package InheritableThreadLocal1;

public class ThreadA extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			for(int i=0;i<10;i++){
				System.out.println("在ThreadA线程中取值"+Tools.tl.get());
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
