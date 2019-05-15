package deadLockTest;

public class DealThread implements Runnable {
	public String userName;
	public Object lock1=new Object();
	public Object lock2=new Object();
	public void setFlag(String userName){
		this.userName=userName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(userName.equals("a")){
			synchronized(lock1){
				try {
					System.out.println("username="+userName);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(lock2){
					System.out.println("按lock1->lock2代码顺序执行了");
				}
			}
		
			
		}
		if(userName.equals("b")){
			synchronized(lock2){
				try {
					System.out.println("username="+userName);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(lock1){
					System.out.println("按lock2->lock1代码顺序执行了");
				}
			}
			
		}
	}

}
