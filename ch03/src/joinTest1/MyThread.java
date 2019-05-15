package joinTest1;

public class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			int secondValue=(int)(Math.random()*10000);
			System.out.println(secondValue+"--"+System.currentTimeMillis());
			Thread.sleep(secondValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
