package java_Thread01;

class CutomerInfo {
	static String name;
	static int sum;
	
	public CutomerInfo(String name, int sum) {
		this.name = name;
		this.sum = sum;
	}
	
	public Account()
}//고객 정보 클래스 

class ThreadBank1 extends Thread{

	public void run() {
		System.out.println("1st 고객 입장");
	}
}//1번 손님 클래스 

class ThreadBank2 extends Thread{

	public void run() {
		System.out.println("2nd 고객 입장");
	}
	
}//2번 손님 클래스 

public class ThreadMainClass6 {

	public static void main(String[] args) {
		CutomerInfo ci1=new CutomerInfo("정은주",300);
		CutomerInfo ci2=new CutomerInfo("서원국",500);
		
		ThreadBank1 tb1=new ThreadBank1();
		ThreadBank2 tb2=new ThreadBank2();
		
		tb1.start();
		tb2.start();
		
	}

}
