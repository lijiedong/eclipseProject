package syn_Out_asyn;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList mylist=new MyList();
		MyThreadA a=new MyThreadA(mylist);
		a.setName("A");
		a.start();
		MyThreadB b=new MyThreadB(mylist);
		b.setName("B");
		b.start();
	}

}
