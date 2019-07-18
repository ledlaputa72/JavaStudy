package Day044_Thread2;
//잘못된 경우의 예시
class RunnerbleClass6 implements Runnable{

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) { 
			System.out.print(Thread.currentThread().isInterrupted());
			System.out.println("쓰레드1");
			try {//try문 위치가 중요:인터럽트 후 다시 false가 되면서 while문 반복
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("catch");
				System.out.println(Thread.currentThread().isInterrupted());
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().isInterrupted());
		}
	}
	
}

public class RunnerbleMainClass6 {

	public static void main(String[] args) throws InterruptedException {
		
		RunnerbleClass6 rc6=new RunnerbleClass6();
		Thread th6=new Thread(rc6);
		th6.start();
		Thread.sleep(5000);
		th6.interrupt();
	}

}
