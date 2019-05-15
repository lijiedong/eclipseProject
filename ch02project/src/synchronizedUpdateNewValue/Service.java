package synchronizedUpdateNewValue;

public class Service {
	public boolean isContinueRun=true;
	public void runMethod(){
		while(isContinueRun){
			
		}
	    System.out.println("停下来了");
	}
	public void stopMethod(){
		isContinueRun=false;
	}
}
