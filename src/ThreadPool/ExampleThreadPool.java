package ThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleThreadPool {
	
	int 	m_threadCnt;
	int 	m_poolSize;
	
	public ExampleThreadPool(int threadCnt, int poolSize){
		this.m_threadCnt = threadCnt;
		this.m_poolSize = poolSize;
	}
	
	public void Run() {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(m_poolSize);
		
		for (int i = 0; i < m_threadCnt; i++){
			threadPool.execute(new RunnableThreadPool(i));
		}
		threadPool.shutdown();
		while(!threadPool.isTerminated()){}
		
		System.out.println("Example finished");
	}
}
