package Mutex;
public class ExampleMutex {
	
	Object 	m_mutex;
	int 	m_threadCnt;
	int 	m_t1, m_t2;
	
	
	
	public ExampleMutex(int threadCnt, int t1, int t2){
		this.m_threadCnt = threadCnt;
		this.m_t1 = t1;
		this.m_t2 = t2;
	}
	
	public void Run() {
		
		m_mutex = new Object();
		
		Thread[] threads = new Thread[m_threadCnt]; 
		
		for (int i = 0; i < m_threadCnt; i++){
			threads[i] = new ThreadMutexed(m_mutex, m_t1, m_t2);
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
