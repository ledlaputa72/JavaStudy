package java_Thread01;

class ThreadClass2 extends Thread {
	
	public void run() { //ThreadClass2 Ŭ������ ������ �۾�
			System.out.println(getName()+" ���� ��������");
	}
}

public class ThreadMainClass2 {

	public static void main(String[] args) {
		ThreadClass2 tc1=new ThreadClass2();
		ThreadClass2 tc2=new ThreadClass2();
		
		tc1.start(); //ThreadClass2�� run ȣ�� 
		tc2.start();
	}

}
