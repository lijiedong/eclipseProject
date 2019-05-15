package timeTest2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run {
	static class MyTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了时间为："+new Date());
		}
		
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		MyTask task=new MyTask();
		Timer timer=new Timer();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString="2018-12-09 16:18:00";
		Date dateRef=sdf.parse(dateString);
		System.out.println("字符串时间为："+dateRef.toLocaleString()+ "当前时间为："+new Date().toLocaleString());
		timer.schedule(task, dateRef,4000);
	}

}
