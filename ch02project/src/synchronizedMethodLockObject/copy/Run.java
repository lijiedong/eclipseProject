package synchronizedMethodLockObject.copy;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyObject object=new MyObject();
		ThreadA a=new ThreadA(object);
		a.setName("A");
		ThreadB b=new ThreadB(object);
		b.setName("B");
		a.start();
		b.start();
		

	}

}
