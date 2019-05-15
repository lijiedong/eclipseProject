package t1;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HaseSelfPrivateNum numRef=new HaseSelfPrivateNum();
		ThreadA athread=new ThreadA(numRef);
		athread.start();
		ThreadB bthread=new ThreadB(numRef);
		bthread.start();
	}

}
