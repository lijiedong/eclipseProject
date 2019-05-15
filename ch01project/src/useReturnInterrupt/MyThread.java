package useReturnInterrupt;

public class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			if(this.isInterrupted()){
				System.out.println("停止了！");
				return;
			}
			System.out.println("timeer="+System.currentTimeMillis());
		}
	}
	
}
