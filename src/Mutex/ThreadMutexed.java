package Mutex;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadMutexed extends Thread {
	
	Object m_mutex;
	int m_t1, m_t2;
	
	public ThreadMutexed(Object mutex, int t1, int t2){
		this.m_mutex = mutex;
		this.m_t1 = t1;
		this.m_t2 = t2;
	}
	
	@Override
	public void run() {
		
		synchronized(m_mutex){
			System.out.println("Executing thread " + Thread.currentThread().getName() + "...");
			try {
				Thread.sleep(ThreadLocalRandom.current().nextLong(m_t1,  m_t2));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread " + Thread.currentThread().getName() + " finished");
		}
		
		
		
	}
}
