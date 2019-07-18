package Day044_Thread2;

class TheadClass41 implements Runnable{
	public void run() { //!flase ==> ture���� ���ƶ� 
		while(!Thread.currentThread().isInterrupted()) { //���ͷ��Ͱ� �ƴѰ�� - ���ѷ���
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : ������1");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5�ʵڿ� ����***");
	}
}

class TheadClass42 implements Runnable{
	public void run() { //!flase ==> ture���� ���ƶ� 
		while(!Thread.currentThread().isInterrupted()) { //���ͷ��Ͱ� �ƴѰ�� - ���ѷ���
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : ������2");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5�ʵڿ� ����***");
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
