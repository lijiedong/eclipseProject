package t16;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RunThread thread=new RunThread();
			thread.start();
			Thread.sleep(1000);
			thread.setRunning(false);
			System.out.println("已经赋值为false");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
