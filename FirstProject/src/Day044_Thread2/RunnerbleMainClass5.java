package Day044_Thread2;

class RunnerbleClass51 implements Runnable{
	public void run() { //!flase ==> ture���� ���ƶ� 
		while(!Thread.currentThread().isInterrupted()) { //���ͷ��Ͱ� �ƴѰ�� - ���ѷ���
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : ������1");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5�ʵڿ� ����***");
	}
}

class RunnerbleClass52 implements Runnable{
	public void run() { //!flase ==> ture���� ���ƶ� 
		while(!Thread.currentThread().isInterrupted()) { //���ͷ��Ͱ� �ƴѰ�� - ���ѷ���
			System.out.print(Thread.currentThread().isInterrupted()); //false
			System.out.println(" : ������2");
		}
		System.out.print(Thread.currentThread().isInterrupted()); //ture 
		System.out.println("***5�ʵڿ� ����***");
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
