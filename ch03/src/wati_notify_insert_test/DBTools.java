package wati_notify_insert_test;

public class DBTools {
	volatile private boolean prevIsA=false;
	synchronized public void backupA(){
		try {
			while(prevIsA){
				wait();
			}
			for(int i=0;i<5;i++){
				System.out.println("*****");
			}
			prevIsA=true;
			notifyAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized public void backupB(){
		try {
			while(prevIsA==false){
				wait();
			}
			for(int i=0;i<5;i++){
				System.out.println("-----");
			}
			prevIsA=false;
			notifyAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
