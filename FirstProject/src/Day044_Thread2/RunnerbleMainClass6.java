package Day044_Thread2;
//�߸��� ����� ����
class RunnerbleClass6 implements Runnable{

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) { 
			System.out.print(Thread.currentThread().isInterrupted());
			System.out.println("������1");
			try {//try�� ��ġ�� �߿�:���ͷ�Ʈ �� �ٽ� false�� �Ǹ鼭 while�� �ݺ�
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
