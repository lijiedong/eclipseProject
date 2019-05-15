package ConditionTest;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyService myService=new MyService();
		/*MyThreadA a=new MyThreadA(myService);
		a.start();
		ThreadB b=new ThreadB(myService);
		b.start();*/
		MyThreadA[] threadA=new MyThreadA[10];
		ThreadB[] threadB=new ThreadB[10];
		for(int i=0;i<10;i++){
			threadA[i]=new MyThreadA(myService);
			threadB[i]=new ThreadB(myService);
			threadA[i].start();
			threadB[i].start();
			
		}
		
	}

}
