package Day044_Thread2;
//�߸��� ����� ����
class RunnerbleClass6 implements Runnable{

	@Override
	public void run() {
		//try��ġ�� �ٲٸ� ���� 
		try { //try1)
			while (!Thread.currentThread().isInterrupted()) { 

			System.out.print(Thread.currentThread().isInterrupted());
			System.out.println("������1");
			//try {//try2)try�� ��ġ�� �߿�:���ͷ�Ʈ �� �ٽ� false�� �Ǹ鼭 while�� �ݺ�
				Thread.sleep(200);
			} //try1)end
			} catch (InterruptedException e) {
				System.out.println("catch");
				System.out.println(Thread.currentThread().isInterrupted());
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().isInterrupted());
			System.out.println("***5�ʵڿ� ����***");
		//} //try2)end
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
