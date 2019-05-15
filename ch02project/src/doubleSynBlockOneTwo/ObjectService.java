package doubleSynBlockOneTwo;

import org.omg.Messaging.SyncScopeHelper;

public class ObjectService {
	public void serviceMehtodA(){
		try {
			synchronized(this){
				System.out.println("A begin time="+System.currentTimeMillis());				
				Thread.sleep(2000);
				System.out.println("A end end="+System.currentTimeMillis());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void serviceMethodB(){
		synchronized(this){
			System.out.println("B begin time="+System.currentTimeMillis());				
			System.out.println("B end end="+System.currentTimeMillis());
		}
	}
}
