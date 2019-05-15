
public class Service {
	Object obj1=new Object();
	 public void methodA(){
		 synchronized(obj1){
			 System.out.println("methodA begin");
				boolean isContinueRun=true;
				while(isContinueRun){
					
				}
				System.out.println("methodA end");
		 }
		
	}
	 Object obj2=new Object();
	 public void methodB(){
		 synchronized(obj2){
			 System.out.println("methodB begin");
				System.out.println("methodB end");
		 }
		
	}
}
