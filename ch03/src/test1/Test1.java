package test1;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String lock=new String();
			System.out.println("syn上面");
			
			synchronized(lock){
				System.out.println("syn第一行");
				lock.wait();
				System.out.println("wait下的代码");
			}
			System.out.println("syn下面的代码");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
