package Day044_Thread2;

class RunnableClass implements Runnable {
	
	public void run() {
		System.out.println("������ ����");
	}
}

public class RunnableMainClass {

	public static void main(String[] args) {
		
		RunnableClass rc1=new RunnableClass(); //implements
		Thread th1=new Thread(rc1); //extends Thread, RunnableClass�� Thread Ŭ������ �����. 
		th1.start(); //����(extends Thread)���� rc1.start�� ������ �ѹ� ���ļ� ������ ���
		//System.out.println("���� RunnerbleMainClass");

	}

}
