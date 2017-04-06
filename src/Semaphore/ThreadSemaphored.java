package Semaphore;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadSemaphored extends Thread {
	
	Semaphore m_semaphore;
	int m_t1, m_t2;
	
	public ThreadSemaphored(Semaphore semaphore, int t1, int t2){
		this.m_semaphore = semaphore;
		this.m_t1 = t1;
		this.m_t2 = t2;
	}
	
	@Override
	public void run() {

		try {
			m_semaphore.acquire();
			System.out.println("Executing thread " + Thread.currentThread().getName() + "...");
			Thread.sleep(ThreadLocalRandom.current().nextLong(m_t1,  m_t2));
			System.out.println("Thread " + Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		m_semaphore.release();
		
	}
}
