package Day044_Thread;

class RunnableClass40 implements Runnable{
	
	private String str;

	//생성자
	public RunnableClass40() {
		this.str="사랑한다";
	}
	
	public RunnableClass40(String str) {
		this.str=str;
	}
	
	@Override
	public void run() {
		 for (int i = 1; i <= 10; i++) {
             System.out.println(i+"번 " + this.str);
             //아래 딜레이를 줄 경우 결과 차이가 발생
             int time=((int)Math.ceil(Math.random()*5000));
			try {
			Thread.sleep(time);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			
        }
	}
}

public class RunnableMainClass4 {

	public static void main(String[] args) {
		Thread th41=new Thread(new RunnableClass40());//디폴트 생성자
		
		Thread th42=new Thread(new RunnableClass40("썸이다")); //생성자 이용
		
		th41.start();
		th42.start();
	}
}
