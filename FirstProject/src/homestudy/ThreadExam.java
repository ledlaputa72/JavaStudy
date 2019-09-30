package homestudy;

class Thread1 extends Thread{
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.print("Thread1"+i+" ");
		}
	}
}


public class ThreadExam {

	public static void main(String[] args) {
		Thread1 t=new Thread1();
		
		t.start();
		
		for (int i = 0; i < 1000; i++) {
			System.out.print("main"+i+" ");
		}
	}

}
