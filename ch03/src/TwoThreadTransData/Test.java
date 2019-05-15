package TwoThreadTransData;

public class Test {

	public static void main(String[] args) {
		MyList service=new MyList();
		// TODO Auto-generated method stub
		ThreadB b=new ThreadB(service);
		b.setName("B");
		b.start();
		
		ThreadA a=new ThreadA(service);
		a.setName("A");
		a.start();
		
	}

}
