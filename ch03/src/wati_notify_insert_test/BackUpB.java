package wati_notify_insert_test;

public class BackUpB extends Thread {
	private DBTools dbtools;

	public BackUpB(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		dbtools.backupB();
	}
	
}
