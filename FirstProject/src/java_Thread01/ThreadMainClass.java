package java_Thread01;

//import java.lang.*;

class ThreadClass extends Thread {
	
	public void run() {
		System.out.println("쓰레드와 오늘부터 1일");
	}
	
}

public class ThreadMainClass {

	public static void main(String[] args) {
		ThreadClass tc1=new ThreadClass(); //delegation
		tc1.start(); //ThreadClass의 run()호출 Start때문에 쓰레드가 만들어짐 
		System.out.println("쓰레드하자"); 
	}

}
