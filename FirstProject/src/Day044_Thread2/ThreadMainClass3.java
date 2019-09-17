package Day044_Thread2;

class TheadClass3 implements Runnable{

	@Override
	public void run() {
		
		/*while(true) { //���ѷ��� 
			System.out.println("���ѷ���");
		}*/
		//���ѷ��� �����ϱ� 
		while (true) {
			System.out.println("���ѷ���");
			if(Thread.interrupted())
				break;
		}
		System.out.println("****5���Ŀ� ����˴ϴ�.****");
	}
}

public class ThreadMainClass3 {

	public static void main(String[] args) throws InterruptedException{
		 
		Thread tr30=new Thread(new TheadClass3());
		tr30.start();
		
		
		Thread.sleep(5000);
		//5���Ŀ� interrupt �Ǿ� Thread ���� // ���⼭ throws�� ����
		
		tr30.interrupt(); //Thread stop�� ���� 
		//1) interrupt()���
		//2) flag-stop ����� CPU�� ���ϰ� ���� �ɸ��Ƿ� �������� ���� 
	}

}
