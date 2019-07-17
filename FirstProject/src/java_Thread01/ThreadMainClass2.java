package java_Thread01;

class ThreadClass2 extends Thread {
	
	public void run() { //ThreadClass2 클래스가 수행할 작업
			System.out.println(getName()+" 나는 쓰레드라는");
	}
}

public class ThreadMainClass2 {

	public static void main(String[] args) {
		ThreadClass2 tc1=new ThreadClass2();
		ThreadClass2 tc2=new ThreadClass2();
		
		tc1.start(); //ThreadClass2의 run 호출 
		tc2.start();
	}

}
