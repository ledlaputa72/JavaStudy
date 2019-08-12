package Day044_Thread2;

class RunnableClass implements Runnable {
	
	public void run() {
		System.out.println("쓰레드 시작");
	}
}

public class RunnableMainClass {

	public static void main(String[] args) {
		
		RunnableClass rc1=new RunnableClass(); //implements
		Thread th1=new Thread(rc1); //extends Thread, RunnableClass를 Thread 클래스로 만든다. 
		th1.start(); //평상시(extends Thread)에는 rc1.start로 했으나 한번 거쳐서 쓰레드 사용
		//System.out.println("나는 RunnerbleMainClass");

	}

}
