package Day045_Thread3_Network;

//ThreadClass///////////////////////////////////////
class ThreadClass extends Thread{
	
	public void run() {
		ThreadClass1 tc1=new ThreadClass1(); //
		tc1.start(); //
		System.out.println("미래:경석아 너 언제와!");
		for (int i = 0; i < 10; i++) {
			try {
				tc1.join(); //기다리는 사람 미래 
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("미래:(경석이)왔니.(마침 야구경기 시작됨)");
	}//run end
}//ThreadClass end

//ThreadClass1///////////////////////////////////////
class ThreadClass1 extends Thread{

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("경석: 빨리먹어~ 미래한테 가야해~");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//run end
}// ThreadClass1 end

public class ThreadMainClass {

	public static void main(String[] args) throws InterruptedException {
		ThreadClass tc1=new ThreadClass(); //delegation
		tc1.start(); //run() 메소드 호출
		System.out.println("오늘은 스크린 야구장 가는날~");
	}
}
