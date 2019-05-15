package synchronizedOneThreadIn;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectService service=new ObjectService();
		ThreadA a=new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadB b=new ThreadB(service);
		b.setName("b");
		b.start();
	}

}
