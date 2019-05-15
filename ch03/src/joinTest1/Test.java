package joinTest1;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread threadTest=new MyThread();
		threadTest.start();
		/*System.out.println("我想当threadTest对象执行完毕后我再执行");
		System.out.println("但上面代码中的sleep()应该写多少呢");
		System.out.println("答案是：根本不能确定!");*/
		threadTest.join();
		System.out.println("我想当threadTest对象执行完毕后我再执行，我做到了"+System.currentTimeMillis());
	}

}
