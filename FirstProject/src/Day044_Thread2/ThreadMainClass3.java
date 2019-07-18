package Day044_Thread2;

class TheadClass3 implements Runnable{

	@Override
	public void run() {
		while(true) { //公茄风橇 
			System.out.println("公茄风橇");
		}
	}
}

public class ThreadMainClass3 {

	public static void main(String[] args) {
		 
		Thread tr30=new Thread(new TheadClass3());
	}

}
