package t9;

public class MyThread2 extends Thread {
	private MyOneList list;
	public MyThread2(MyOneList list){
		super();
		this.list=list;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		MyService msRef=new MyService();
		System.out.println(System.currentTimeMillis());
		msRef.addServiceMethod(list, "A");
	}
	
}
