package Day044_Thread2;

public class ThreadMainClass2 {

	public static void main(String[] args) {
		
		new Thread() { //Thread1 class ////////////////
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("아하 쓰레드구만");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
		}.start(); //Thread1 class end ////////////////
		
		new Thread() { //Thread2 class ////////////////
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("정말 쓰레드");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start(); //Thread2 class end ////////////////

	}//main end

}
