package Day044_Thread2;

class RunnerbleClass51 implements Runnable{
	public void run() { //!flase ==> ture동안 돌아라 
		while(!Thread.currentThread().isInterrupted()) { //인터럽터가 아닌경우 - 무한루프
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : 쓰레드1");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5초뒤에 종료***");
	}
}

class RunnerbleClass52 implements Runnable{
	public void run() { //!flase ==> ture동안 돌아라 
		while(!Thread.currentThread().isInterrupted()) { //인터럽터가 아닌경우 - 무한루프
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : 쓰레드2");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5초뒤에 종료***");
	}
}

public class RunnerbleMainClass5 {

	public static void main(String[] args) throws InterruptedException {

		Thread tr51=new Thread(new RunnerbleClass51());
		Thread tr52=new Thread(new RunnerbleClass52());
		
		tr51.start();
		tr52.start();
		
		Thread.sleep(5000);
		tr51.interrupt();
		tr52.interrupt();
		
	}

}
