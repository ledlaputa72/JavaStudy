package Day044_Thread;

public class ThreadMainClass2 {

	public static void main(String[] args) {
		
		new Thread() { //Thread1 class ////////////////
			public void run() {
				System.out.println("���� �����屸��");
			}
		}.start(); //Thread1 class end ////////////////
		
		new Thread() { //Thread2 class ////////////////
			public void run() {
				System.out.println("���� ������");
			}
		}.start(); //Thread2 class end ////////////////

	}//main end

}
