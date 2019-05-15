package t99;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintString ps=new PrintString();
		new Thread(ps).start();
		System.out.println("我要停止它!stopThread="+Thread.currentThread().getName());
		ps.setContinuePrint(false);
		
	}

}
