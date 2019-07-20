package Day045_Thread3_Network;

//ThreadClass///////////////////////////////////////
class ThreadClass extends Thread{
	
	public void run() {
		ThreadClass1 tc1=new ThreadClass1(); //
		tc1.start(); //
		System.out.println("�̷�:�漮�� �� ������!");
		for (int i = 0; i < 10; i++) {
			try {
				tc1.join(); //��ٸ��� ��� �̷� 
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�̷�:(�漮��)�Դ�.(��ħ �߱���� ���۵�)");
	}//run end
}//ThreadClass end

//ThreadClass1///////////////////////////////////////
class ThreadClass1 extends Thread{

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�漮: �����Ծ�~ �̷����� ������~");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//run end
}// ThreadClass1 end

public class ThreadMainClass {

	public static void main(String[] args) throws InterruptedException {
		ThreadClass tc1=new ThreadClass(); //delegation
		tc1.start(); //run() �޼ҵ� ȣ��
		System.out.println("������ ��ũ�� �߱��� ���³�~");
	}
}
