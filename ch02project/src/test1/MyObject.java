package test1;

public class MyObject {
//	synchronized public void speedPrintString(){
//		System.out.println("speedPrintString___getLock time="+
//				System.currentTimeMillis()+" run ThreadName="+ Thread.currentThread().getName());
//			System.out.println("-----------------------------------------");
//				System.out.println("speedPrintString releaseLock time="+
//						System.currentTimeMillis()+" run ThreadName="+ Thread.currentThread().getName());
//		
//	}
	public void speedPrintString(){
		synchronized(this){
			System.out.println("speedPrintString___getLock time="+
					System.currentTimeMillis()+" run ThreadName="+ Thread.currentThread().getName());
				System.out.println("-----------------------------------------");
					System.out.println("speedPrintString releaseLock time="+
							System.currentTimeMillis()+" run ThreadName="+ Thread.currentThread().getName());
			
		}
	}
}
