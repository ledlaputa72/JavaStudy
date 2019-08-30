package Day044_Thread2;

class TheadClass3 implements Runnable{

	@Override
	public void run() {
		
		/*while(true) { //무한루프 
			System.out.println("무한루프");
		}*/
		//무한루프 중지하기 
		while (true) {
			System.out.println("무한루프");
			if(Thread.interrupted())
				break;
		}
		System.out.println("****5초후에 종료됩니다.****");
	}
}

public class ThreadMainClass3 {

	public static void main(String[] args) throws InterruptedException{
		 
		Thread tr30=new Thread(new TheadClass3());
		tr30.start();
		
		
		Thread.sleep(5000);
		//5초후에 interrupt 되어 Thread 멈춤 // 여기서 throws를 선택
		
		tr30.interrupt(); //Thread stop을 위해 
		//1) interrupt()방식
		//2) flag-stop 방식은 CPU에 부하가 많이 걸리므로 권장하지 않음 
	}

}
