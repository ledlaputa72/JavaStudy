package Day044_Thread;

class TheadClass3 implements Runnable{

	@Override
	public void run() {
		while(true) { //무한루프 
			System.out.println("무한루프");
		}
	}
}

public class ThreadMainClass3 {

	public static void main(String[] args) {
		 
		Thread tr30=new Thread(new TheadClass3());
	}

}
