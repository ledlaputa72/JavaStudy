package Day043_Thread;

class ThreadClassTest1 extends Thread{
	String irum; //�ʱ�ġ�� �漮 
	//������
	public ThreadClassTest1(String irum) {
		this.irum=irum; //irum���� ���� "�漮"�� this.irum���� �����Ͽ� �ʱ�ġ�� �Է� 
	}

	public void run() {
//		Thread.currentThread().setName("�漮:");
		for (int i = 0; i < 10; i++) {
			System.out.println(irum+" (�̷������ ���ȴ� ���ƿ���) ȯ�ڱ���!!!"); //getName ��� ���
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}//ThreadClassTest1 end

class ThreadClassTest2 extends Thread{
	String irum;
	//������
	public ThreadClassTest2(String irum) {
		this.irum=irum;
	}

	public void run() {
		Thread.currentThread().setName("����:");
		for (int i = 0; i < 10; i++) {
			System.out.println(irum+" (�漮�̸� �Ϻη� ��������) �̷��� �ƹ��� ���� ����!!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}//ThreadClassTest2 end

public class ThreadMainClass5 {

	public static void main(String[] args) {
		ThreadClassTest1 tct1=new ThreadClassTest1("�漮"); //������ �߰� 
		ThreadClassTest2 tct2=new ThreadClassTest2("����"); //������ �߰� 
		
		System.out.println("ȸ�� ��� ü���� ��Ǯ�� ��ģ�� ... ����� ��");
		tct1.start();
		tct2.start();
	}
}
