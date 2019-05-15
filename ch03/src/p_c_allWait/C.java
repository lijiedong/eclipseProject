package p_c_allWait;

public class C {
	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}
	public void getValue(){
		try {
			synchronized (lock) {
				while(ValueObject.value.equals("")){
					System.out.println("消费者"+Thread.currentThread().getName()
							+" waiting");
					lock.wait();
				}
				System.out.println("消费者"+Thread.currentThread().getName()+"Runnable");
				
				ValueObject.value="";
				lock.notifyAll();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
