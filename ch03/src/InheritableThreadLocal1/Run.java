package InheritableThreadLocal1;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<10;i++){
				System.out.println("  在main线程中取值="+Tools.tl.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			ThreadA a =new ThreadA();
			a.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
