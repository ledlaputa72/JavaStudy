package homestudy01;

class MyThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("���� ����ǰ� �ִ� �������� ���� : "+Thread.activeCount());
		System.out.println("���� ����Ǵ� �������� ���� : " + Thread.currentThread());
	}
	
	
}

public class Exam_02 {

	public static void main(String[] args) {
		MyThread2 mt=new MyThread2();
		Thread tr=new Thread(mt);
		tr.start();
	}
}
