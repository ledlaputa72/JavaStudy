package java_Thread01;

class ThreadClass03 extends Thread {
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+" ���� ��� �ִ�.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//for end
	}
} //ThreadClass03 end

class ThreadClass04 extends Thread {
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName()+" �װ� ��� �ִ�.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//for end
	}
} //ThreadClass04 end

public class ThreadMainClass4 {

	public static void main(String[] args) {
		ThreadClass03 tc03=new ThreadClass03(); //����Ʈ ������ 
		ThreadClass04 tc04=new ThreadClass04();
		
		tc03.start();
		tc04.start();
	}
}
