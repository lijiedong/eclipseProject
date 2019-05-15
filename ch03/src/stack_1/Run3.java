package stack_1;

public class Run3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack myStack=new MyStack();
		P p1=new P(myStack);
		P p2=new P(myStack);
		P p3=new P(myStack);
		P p4=new P(myStack);
		P p5=new P(myStack);
		P p6=new P(myStack);
		P_Thread pTHread1=new P_Thread(p1);
		P_Thread pTHread2=new P_Thread(p2);
		P_Thread pTHread3=new P_Thread(p3);
		P_Thread pTHread4=new P_Thread(p4);
		P_Thread pTHread5=new P_Thread(p5);
		P_Thread pTHread6=new P_Thread(p6);
		pTHread1.start();
		pTHread2.start();
		pTHread3.start();
		pTHread4.start();
		pTHread5.start();
		pTHread6.start();
		C c1=new C(myStack);
		C_Thread cThread=new C_Thread(c1);
		cThread.start();
	}

}
