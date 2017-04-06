/**
 * 
 */
import java.util.Scanner;

import Atomic.ExampleAtomic;
import Mutex.ExampleMutex;
import Semaphore.ExampleSemaphore;
import ThreadPool.ExampleThreadPool;
/**
 * @author Admin
 *
 */

public class source {

	static void RunMutex(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter thread count: ");
		int cnt = 10; //scanner.nextInt();
		
	    System.out.print("Enter t1: ");
	    int t1 = 1000;//scanner.nextInt();
	    
	    System.out.print("Enter t2: ");
	    int t2 = 2000;//scanner.nextInt();
	    
	    scanner.close();
	    
	    ExampleMutex example = new ExampleMutex(cnt, t1, t2);
	    example.Run();
	}
	
	static void RunSemaphore() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter thread count: ");
		int cnt = 10; //scanner.nextInt();
		
	    System.out.print("Enter t1: ");
	    int t1 = 1000;//scanner.nextInt();
	    
	    System.out.print("Enter t2: ");
	    int t2 = 2000;//scanner.nextInt();
	    
	    scanner.close();
	    
	    ExampleSemaphore example = new ExampleSemaphore(cnt, t1, t2);
	    example.Run();
	    
	}
	
	static void RunAtomic() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter thread count: ");
		int cnt = 10; //scanner.nextInt();
			    
	    scanner.close();
	    
	    ExampleAtomic example = new ExampleAtomic(cnt);
	    example.Run();	}
	
	static void RunThreadPool() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter thread-pool size: ");
		int size = 4; //scanner.nextInt();
		
		System.out.print("Enter thread count: ");
		int cnt = 10; //scanner.nextInt();
		 
	    scanner.close();
	    
	    ExampleThreadPool example = new ExampleThreadPool(cnt, size);
	    example.Run();
	}
	
	public static void main(String[] args) {
				
		System.out.println("1. Mutex");
		System.out.println("2. Semaphore");
		System.out.println("3. Atomic");
		System.out.println("4. Thread-pool\n");
		System.out.print("Your choice: ");
		
		Scanner scanner = new Scanner(System.in);
	    int choice = scanner.nextInt();
	    scanner.close();
	    
	    switch (choice){
	    case 1:
	    	RunMutex();
	    	break;
	    	
	    case 2:
	    	RunSemaphore();
	    	break;
	    	
	    case 3:
	    	RunAtomic();
	    	break;
	    	
	    case 4:
	    	RunThreadPool();
	    	break;
	    }

	}

}
