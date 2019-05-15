package t6;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task=new Task();
		MyThread1 thread1=new MyThread1(task);
		thread1.setName("aa");
		thread1.start();
		MyThread2 thread2=new MyThread2(task);
		thread2.setName("bb");
		thread2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long beginTime=CommonUtils.beginTime1;
		if(CommonUtils.beginTime2<CommonUtils.beginTime1){
			beginTime=CommonUtils.beginTime2;
		}
		long endTime=CommonUtils.endTime1;
		if(CommonUtils.endTime2>CommonUtils.endTime1){
			endTime=CommonUtils.endTime2;
		}
		System.out.println("耗时："+((endTime-beginTime))/1000);
	}

}
