package Day044_Thread;

class ThreeThreadClass extends Thread {
	
	private String kwail;
	
	//������
	public ThreeThreadClass(String kwail) {
		this.kwail=kwail;
	}
	
	//run �޼ҵ�
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(this.kwail+"\t"+i+"�� �ּ���");
		}
	}
}

public class ThreeThreadMainClass {

	public static void main(String[] args) {
		//������ ������� ó�� 
		ThreeThreadClass ttc1 = new ThreeThreadClass("���");
		ThreeThreadClass ttc2 = new ThreeThreadClass("��");
		ThreeThreadClass ttc3 = new ThreeThreadClass("��");
		
		ttc1.start();
		ttc2.start();
		ttc3.start();
	}

}
