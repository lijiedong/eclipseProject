package test1;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Service service=new Service();
		Runnable runnable=new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+"调用时间未"+System.currentTimeMillis());
				service.waitMethod();
			}
			
		};
		Thread ta=new Thread(runnable);
		ta.setName("a");
		ta.start();
		
		Thread tb=new Thread(runnable);
		tb.setName("b");
		tb.start();
		}
	

}
