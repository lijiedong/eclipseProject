package synBlockString;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Service service=new Service();
		ThreadA a=new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadB b=new ThreadB(service);
		b.setName("B");
		b.start();
	}

}
