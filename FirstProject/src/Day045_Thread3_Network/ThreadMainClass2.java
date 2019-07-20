package Day045_Thread3_Network;

//ThreadClass2///////////////////////////////////////
class ThreadClass2 extends Thread{
	
	public void run() {
		ThreadClass21 tc21=new ThreadClass21(); //
		tc21.start(); //
		System.out.println("미래:경석아 너 언제와!");
		for (int i = 0; i < 10; i++) {
			try {
				tc21.join(7000); //7초 기다리고 아래로 내려감 
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("[메모남김] 경석아! 급한일이 생겨 집에간다. ");
		System.out.println("(경석이 야구장에 도착함");
		System.out.println("메모본후 ㅠ.ㅠ.......");
		System.exit(1); //강제종료 (정상종료:0 , 비정상종료:0이 아닌값)
	}//run end
}//ThreadClass2 end

//ThreadClass21///////////////////////////////////////
class ThreadClass21 extends Thread{

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
}// ThreadClass21 end


public class ThreadMainClass2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadClass2 tc2=new ThreadClass2(); //delegation
		tc2.start(); //run() 메소드 호출
		System.out.println("오늘은 스크린 야구장 가는날~");
	}
}
