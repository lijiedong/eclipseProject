package wati_notify_insert_test;

public class BackUpA extends Thread {
	private DBTools dbtools;

	public BackUpA(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		dbtools.backupA();
	}
	
}
