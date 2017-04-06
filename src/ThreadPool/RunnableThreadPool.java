package ThreadPool;
import java.util.concurrent.ThreadLocalRandom;

public class RunnableThreadPool implements Runnable {
		
	int m_taskId;
	
	public RunnableThreadPool(int taskId) {
		this.m_taskId = taskId;
	}
	@Override
	public void run() {
		
	
			System.out.println("Executing task " + m_taskId + "...");
			try {
				Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Task " + m_taskId + " finished");
		
		
		
		
	}
}
