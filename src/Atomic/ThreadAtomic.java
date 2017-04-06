package Atomic;

public class ThreadAtomic extends Thread {
	
	ConcurrentStack m_stack;
	boolean m_isPushing;
	
	public ThreadAtomic(ConcurrentStack stack, boolean isPushing){
		this.m_stack = stack;
		this.m_isPushing = isPushing;
	}
	
	@Override
	public void run() {
		
		if (m_isPushing) {
			m_stack.push("Task by" + Thread.currentThread().getName());
		}
		else {
			String elem = m_stack.pop();
			System.out.println("Thread " + Thread.currentThread().getName() + " popped element: " + elem);
		}
	}
}
