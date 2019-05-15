package timeTest5;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {
	private static Timer timer=new Timer();
	private static int runCount=0;
	 static public class MyTask1 extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("I begin 运行了!时间为："+new Date().toLocaleString());
			try {
				Thread.sleep(1000);
				System.out.println("I end 运行了!时间为："+new Date().toLocaleString());
				runCount++;
				if(runCount==5){
					timer.cancel();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
	 }

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		MyTask1 task1=new MyTask1();
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString ="2018-12-09 17:21:50";
		Date dateRef=sdf1.parse(dateString);
		System.out.println("字符串时间为"+dateRef.toLocaleString()+"当前时间为："+new Date().toLocaleString());
		//timer.schedule(task1, dateRef,3000);
		timer.scheduleAtFixedRate(task1, dateRef, 2000);
	}

}
