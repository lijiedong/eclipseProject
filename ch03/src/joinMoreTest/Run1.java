package joinMoreTest;

public class Run1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadB b=new ThreadB();
		ThreadA a=new ThreadA(b);
		a.start();
		b.start();
		b.join();
		System.out.println(" main end "+System.currentTimeMillis());
	}

}
