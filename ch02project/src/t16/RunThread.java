package t16;

public class RunThread extends Thread {
	volatile private boolean isRunning =true;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("进入run了");
		while(isRunning){
			
		}
		System.out.println("线程被停止了");
	}
	
}
