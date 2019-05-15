package UseConditionWaitNotifyOK;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyService service=new MyService();
		ThreadA a=new ThreadA(service);
		a.start();
		Thread.sleep(3000);
		service.signal();
	}

}
