package Day044_Thread;

public class ThreadMainClass2 {

	public static void main(String[] args) {
		
		new Thread() { //Thread1 class ////////////////
			public void run() {
				System.out.println("아하 쓰레드구만");
			}
		}.start(); //Thread1 class end ////////////////
		
		new Thread() { //Thread2 class ////////////////
			public void run() {
				System.out.println("정말 쓰레드");
			}
		}.start(); //Thread2 class end ////////////////

	}//main end

}
