package java_Thread01;

//import java.lang.*;

class ThreadClass extends Thread {
	
	public void run() {
		System.out.println("������� ���ú��� 1��");
	}
	
}

public class ThreadMainClass {

	public static void main(String[] args) {
		ThreadClass tc1=new ThreadClass(); //delegation
		tc1.start(); //ThreadClass�� run()ȣ�� Start������ �����尡 ������� 
		System.out.println("����������"); 
	}

}
