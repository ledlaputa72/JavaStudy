package java_Thread01;

class CutomerInfo {
	static String name;
	static int sum;
	
	public CutomerInfo(String name, int sum) {
		this.name = name;
		this.sum = sum;
	}
	
	public Account()
}//�� ���� Ŭ���� 

class ThreadBank1 extends Thread{

	public void run() {
		System.out.println("1st �� ����");
	}
}//1�� �մ� Ŭ���� 

class ThreadBank2 extends Thread{

	public void run() {
		System.out.println("2nd �� ����");
	}
	
}//2�� �մ� Ŭ���� 

public class ThreadMainClass6 {

	public static void main(String[] args) {
		CutomerInfo ci1=new CutomerInfo("������",300);
		CutomerInfo ci2=new CutomerInfo("������",500);
		
		ThreadBank1 tb1=new ThreadBank1();
		ThreadBank2 tb2=new ThreadBank2();
		
		tb1.start();
		tb2.start();
		
	}

}
