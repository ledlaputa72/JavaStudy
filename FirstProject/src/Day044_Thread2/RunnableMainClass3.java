package Day044_Thread2;

class RunnableClass10 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("»ç¶ûÇÕ´Ï´Ù.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RunnableClass20 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Ich Liebe Dich");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class RunnableMainClass3 {

	public static void main(String[] args) {
		RunnableClass10 rc10=new RunnableClass10();  
		Thread th10=new Thread(rc10);
		
		RunnableClass20 rc20=new RunnableClass20();  
		Thread th20=new Thread(rc20);
		
		th10.start();
		th20.start();
	}
}
