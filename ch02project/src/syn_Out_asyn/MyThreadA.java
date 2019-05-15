package syn_Out_asyn;

public class MyThreadA extends Thread {
	private MyList list;

	public MyThreadA(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<100000;i++){
			list.add("ThreadA"+(i+1));
		}
	}
	
}
