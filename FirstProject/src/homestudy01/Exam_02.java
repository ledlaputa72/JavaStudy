package homestudy01;

class MyThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("현재 실행되고 있는 쓰레드의 갯수 : "+Thread.activeCount());
		System.out.println("현재 실행되는 쓰레드의 상태 : " + Thread.currentThread());
	}
	
	
}

public class Exam_02 {

	public static void main(String[] args) {
		MyThread2 mt=new MyThread2();
		Thread tr=new Thread(mt);
		tr.start();
	}
}
