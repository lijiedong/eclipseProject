package pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
				WriteData writeData=new WriteData();
				ReadData readData=new ReadData();
				
				PipedInputStream inputStream=new PipedInputStream();
				PipedOutputStream outputStream=new PipedOutputStream();
			
			outputStream.connect(inputStream);
			ThreadRead threadRead=new ThreadRead(readData, inputStream);
			threadRead.start();
			Thread.sleep(2000);
			ThreadWrite threadWrite=new ThreadWrite(writeData, outputStream);
			threadWrite.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
