package Day044_Thread2;

class TheadClass41 implements Runnable{
	public void run() { //!flase ==> ture동안 돌아라 
		while(!Thread.currentThread().isInterrupted()) { //인터럽터가 아닌경우 - 무한루프
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : 쓰레드1");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5초뒤에 종료***");
	}
}

class TheadClass42 implements Runnable{
	public void run() { //!flase ==> ture동안 돌아라 
		while(!Thread.currentThread().isInterrupted()) { //인터럽터가 아닌경우 - 무한루프
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : 쓰레드2");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5초뒤에 종료***");
	}
}

public class ThreadMainClass4 {

	public static void main(String[] args) throws InterruptedException {

		Thread tr41=new Thread(new TheadClass41());
		Thread tr42=new Thread(new TheadClass42());
		
		tr41.start();
		tr42.start();
		
		Thread.sleep(5000);
		tr41.interrupt();
		tr42.interrupt();
		
	}

}
