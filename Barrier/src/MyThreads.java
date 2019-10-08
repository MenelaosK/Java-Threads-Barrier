import java.util.concurrent.TimeUnit;

public class MyThreads extends Thread{
	Barrier barrier;
	int threadID;
	
	public MyThreads(int tId,Barrier frag) {
		this.threadID=tId;
		this.barrier=frag;
	}
	
	public void run() {
		while(true) {
			System.out.println("Thread "+threadID+" started");
			barrier.fraksimo();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("Thread "+threadID+" arrived at the barrier");
			barrier.fraksimo();
			System.out.println("Thread "+threadID+" passed the barrier");
			barrier.fraksimo();
			
			
		}
		
		
		
	}

}
