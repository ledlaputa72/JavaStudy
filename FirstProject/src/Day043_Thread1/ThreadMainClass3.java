package Day043_Thread1;

class ThreadClass01 extends Thread {
	
	public void run() {
		System.out.println(getName()+" 나는 나야");
		System.out.println("All you need is Love");
	}
} //ThreadClass01 end

class ThreadClass02 extends Thread {
	
	public void run() {
		System.out.println(getName()+" 나도 너 아니거든");
		System.out.println("Love is All you need ");
	}
} //ThreadClass02 end

public class ThreadMainClass3 {

	public static void main(String[] args) {
		ThreadClass01 tc01=new ThreadClass01(); //디폴트 생성자 
		ThreadClass02 tc02=new ThreadClass02();
		
		tc01.start();
		tc02.start();
	}

}
