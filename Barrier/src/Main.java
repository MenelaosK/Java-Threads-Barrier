
public class Main {

	public static void main(String[] args) {
		int threads=4;
		int i;
		Barrier fragma=new Barrier(threads);
		
		MyThreads ts[]=new MyThreads[threads];
		for(i=0;i<threads;i++) {
			ts[i]=new MyThreads(i,fragma);
			ts[i].start();
		}
		

	}
	

}
