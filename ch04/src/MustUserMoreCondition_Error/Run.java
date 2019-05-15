package MustUserMoreCondition_Error;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyService service =new MyService();
		ThreadA a=new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadB b=new ThreadB(service);
		b.setName("B");
		b.start();
		Thread.sleep(3000);
		service.signAll();
	}

}
