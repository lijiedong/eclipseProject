package test1;

public class Service {
	public void testMethod1(MyObject object){
		synchronized(object){
			try{
				System.out.println("testMethod1__getLock time="+
			System.currentTimeMillis()+" run ThreadName="+ Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("testMethod1 releaseLock time="+
					System.currentTimeMillis()+" run ThreadName="+ Thread.currentThread().getName());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void test(){
		synchronized(this){
			System.out.println("test"+
					System.currentTimeMillis()+" run ThreadName="+ Thread.currentThread().getName());
		}
	}
}
