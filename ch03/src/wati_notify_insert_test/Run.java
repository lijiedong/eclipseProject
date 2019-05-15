package wati_notify_insert_test;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBTools dbtools=new DBTools();
		for(int i=0;i<20;i++){
			BackUpB output=new BackUpB(dbtools);
			output.start();
			BackUpA input=new BackUpA(dbtools);
			input.start();
		}
	}

}
