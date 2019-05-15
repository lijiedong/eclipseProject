package dirtyRead;

public class PublicVar {
	public String userName="A";
	public String password="AA";
	synchronized public void setValue(String userName,String password){
		
		try {
			this.userName=userName;
			Thread.sleep(5000);
			this.password=password;
			System.out.println("setValue method thread name="+Thread.currentThread().getName()+
					"userName="+userName+ ",password="+password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.password=password;
		
	}
	synchronized public void getValue(){
		System.out.println("getValue method thread name="+Thread.currentThread().getName()+
				userName+ ",password="+password);}
}
