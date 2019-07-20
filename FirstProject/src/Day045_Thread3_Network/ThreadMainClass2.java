package Day045_Thread3_Network;

//ThreadClass2///////////////////////////////////////
class ThreadClass2 extends Thread{
	
	public void run() {
		ThreadClass21 tc21=new ThreadClass21(); //
		tc21.start(); //
		System.out.println("�̷�:�漮�� �� ������!");
		for (int i = 0; i < 10; i++) {
			try {
				tc21.join(7000); //7�� ��ٸ��� �Ʒ��� ������ 
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("[�޸𳲱�] �漮��! �������� ���� ��������. ");
		System.out.println("(�漮�� �߱��忡 ������");
		System.out.println("�޸��� ��.��.......");
		System.exit(1); //�������� (��������:0 , ����������:0�� �ƴѰ�)
	}//run end
}//ThreadClass2 end

//ThreadClass21///////////////////////////////////////
class ThreadClass21 extends Thread{

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
}// ThreadClass21 end


public class ThreadMainClass2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadClass2 tc2=new ThreadClass2(); //delegation
		tc2.start(); //run() �޼ҵ� ȣ��
		System.out.println("������ ��ũ�� �߱��� ���³�~");
	}
}
