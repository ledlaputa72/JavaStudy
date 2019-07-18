package Day044_Thread2;

class ThreadJoinClass extends Thread{

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("쓰레드 시작");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//run end
}

public class ThreadJoinMainClass {

	public static void main(String[] args) throws InterruptedException {
		ThreadJoinClass tcj1=new ThreadJoinClass();
		tcj1.start();
		System.out.println("나는 쓰레드메인클래스");
		tcj1.join();
		System.out.println("쓰레드 마지막");
	}

}
