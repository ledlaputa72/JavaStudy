package Day044_Thread;

class RunnableClass2 implements Runnable{
	@Override
	public void run() {
		System.out.println("������ ����");
	}
}

public class RunnableMainClass2 {

	public static void main(String[] args) {
		RunnableClass2 rc01=new RunnableClass2();  
		Thread th01=new Thread(rc01);
		
		Thread th02=new Thread(new RunnableClass()); //2���� �ѹ��� ���ļ�
		
		th01.start();
		th02.start();
	}

}
