package t12;

public class Run3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread=new MyThread();
		thread.start();
		try {
			Thread.sleep(100);
			thread.interrupt();
			System.out.println("�Ƿ�ֹͣ1:"+thread.isInterrupted());
			System.out.println("�Ƿ�ֹͣ2��"+thread.isInterrupted());
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
