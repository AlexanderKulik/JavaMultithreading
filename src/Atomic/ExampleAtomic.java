package Atomic;

public class ExampleAtomic {
	
	int m_threadCnt;
		
	public ExampleAtomic(int threadCnt){
		this.m_threadCnt = threadCnt;
	}
	
	public void Run() {
		
		ConcurrentStack concurrentStack = new ConcurrentStack();
		
		Thread[] threads = new Thread[m_threadCnt]; 
		
		for (int i = 0; i < m_threadCnt; i++){
			threads[i] = new ThreadAtomic(concurrentStack, true);
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
		
		for (int i = 0; i < m_threadCnt; i++){
			threads[i] = new ThreadAtomic(concurrentStack, false);
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
