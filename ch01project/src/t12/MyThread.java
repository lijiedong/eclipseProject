package t12;

public class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<50000;i++){
			System.out.println("i="+(i+1));
		}
	}
	
}
