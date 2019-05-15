package t6;

public class Task {
	
	public  void doLongTimeTask(){
		try {
			 String getData1;
			 String getData2;
			System.out.println("begin task");
			Thread.sleep(3000);
			String	privategetData1="长时间处理任务后从远程返回1 threadName="+
					Thread.currentThread().getName();
			String privategetData2="长时间处理任务后从远程返回的值2 threadName="+
					Thread.currentThread().getName();
			synchronized (this) {
				getData1=privategetData1;
				getData2=privategetData2;
				
			}
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("end task");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
