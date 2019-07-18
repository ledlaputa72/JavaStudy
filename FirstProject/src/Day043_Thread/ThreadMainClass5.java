package Day043_Thread;

class ThreadClassTest1 extends Thread{
	String irum; //초기치로 경석 
	//생성자
	public ThreadClassTest1(String irum) {
		this.irum=irum; //irum으로 받은 "경석"을 this.irum으로 대입하여 초기치로 입력 
	}

	public void run() {
//		Thread.currentThread().setName("경석:");
		for (int i = 0; i < 10; i++) {
			System.out.println(irum+" (미래보라고 껴안는 수아에게) 환자구나!!!"); //getName 대신 사용
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}//ThreadClassTest1 end

class ThreadClassTest2 extends Thread{
	String irum;
	//생성자
	public ThreadClassTest2(String irum) {
		this.irum=irum;
	}

	public void run() {
		Thread.currentThread().setName("수아:");
		for (int i = 0; i < 10; i++) {
			System.out.println(irum+" (경석이를 일부러 껴안으며) 이래도 아무런 느낌 없어!!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}//ThreadClassTest2 end

public class ThreadMainClass5 {

	public static void main(String[] args) {
		ThreadClassTest1 tct1=new ThreadClassTest1("경석"); //생성자 추가 
		ThreadClassTest2 tct2=new ThreadClassTest2("수아"); //생성자 추가 
		
		System.out.println("회사 향수 체험후 뒷풀이 마친후 ... 비오는 날");
		tct1.start();
		tct2.start();
	}
}
