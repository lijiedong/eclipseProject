package TwoThreadTransData;

import java.nio.channels.InterruptedByTimeoutException;

public class ThreadB extends Thread {
	private MyList list;

	public ThreadB(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			System.out.println("B 线程已经启动了！");
			while(true){	
				//System.out.println(System.currentTimeMillis());
				if(list.size()>5){
				System.out.println("==5了，线程b要退出了");
					throw new InterruptedException();
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
