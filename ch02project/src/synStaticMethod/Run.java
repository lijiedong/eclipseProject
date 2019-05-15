package synStaticMethod;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Service service=new Service();
		Service ser=new Service();
		ThreadA a=new ThreadA(ser);
		a.setName("A");
		a.start();
		ThreadB b=new ThreadB(ser);
		b.setName("B");
		b.start();
		ThreadC c=new ThreadC(ser);
		c.setName("C");
		c.start();
	}

}
