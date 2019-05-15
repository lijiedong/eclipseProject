package test1;

public class Run1_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Service service =new Service();
		MyObject object=new MyObject();
		ThreadA a=new ThreadA(service,object);
		a.setName("A");
		a.start();
		Thread.sleep(100);
		ThreadB b=new ThreadB(service,object);
		b.setName("B");
		b.start();
		
	}

}
