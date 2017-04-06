package Semaphore;
import java.util.concurrent.Semaphore;

public class ExampleSemaphore {
	
	int m_threadCnt;
	int m_t1, m_t2;
	
	final int k_semaphorePermits = 4;
	
	public ExampleSemaphore(int threadCnt, int t1, int t2){
		this.m_threadCnt = threadCnt;
		this.m_t1 = t1;
		this.m_t2 = t2;
	}
	
	public void Run() {
		
		Semaphore semaphore = new Semaphore(k_semaphorePermits);
		Thread[] threads = new Thread[m_threadCnt]; 
		
		for (int i = 0; i < m_threadCnt; i++){
			threads[i] = new ThreadSemaphored(semaphore, m_t1, m_t2);
			threads[i].start();
		}
		
		for (int i = 0; i < m_threadCnt; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Example finished");
	}
}
