import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Barrier{
	
	int numberOfThreads;
	Lock lock=new ReentrantLock();
	Condition cond=lock.newCondition();
	int arrived=0;
	boolean leave=false;
	boolean wait=true;
	
	public Barrier(int sun) {
		this.numberOfThreads=sun;
	}
	
	public void fraksimo() {
		//wait
		lock.lock();
		arrived++;
		if(arrived==numberOfThreads) {
			wait=false;
			leave=true;
		}
		while(wait) {
			try {
				cond.await();
			}
			catch(InterruptedException e) { 
				
			}
			
			
		}cond.signalAll();
		
		lock.unlock();
		
		//leave
				lock.lock();
				arrived--;
				if(arrived==0) {
					wait=true;
					leave=false;
				}
				while(leave) {
					try {
						cond.await();
					}
					catch(InterruptedException e) { 
						
					}
					
					
				}cond.signalAll();
				
				lock.unlock();
	}
	
}
