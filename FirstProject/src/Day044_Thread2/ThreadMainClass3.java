package Day044_Thread2;

class TheadClass3 implements Runnable{

	@Override
	public void run() {
		while(true) { //���ѷ��� 
			System.out.println("���ѷ���");
		}
	}
}

public class ThreadMainClass3 {

	public static void main(String[] args) {
		 
		Thread tr30=new Thread(new TheadClass3());
	}

}
