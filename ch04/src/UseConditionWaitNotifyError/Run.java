package UseConditionWaitNotifyError;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyService service=new MyService();
		ThreadA a=new ThreadA(service);
		a.start();
				
	}

}
