package p_c_allWait;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String lock =new String("");
	    P p=new P(lock);
	    C r=new C(lock);
	    ThreadP[] pThread=new ThreadP[2];
	    ThreadC[] cThread=new ThreadC[2];
	    for(int i=0;i<2;i++){
	    	pThread[i]=new ThreadP(p);
	    	pThread[i].setName("生产者"+(i+1));
	    	cThread[i]=new ThreadC(r);
	    	cThread[i].setName("消费者"+(i+1));
	    	pThread[i].start();
	    	cThread[i].start();
	    	
	    }
	    Thread.sleep(5000);
	    Thread[] threadArray=new Thread[Thread.currentThread().getThreadGroup().activeCount()];
	    Thread.currentThread().getThreadGroup().enumerate(threadArray);
	    for(int i=0;i<threadArray.length;i++){
	    	System.out.println(threadArray[i].getName()+ " "
	    			+threadArray[i].getState());
	    }
	    }

}
