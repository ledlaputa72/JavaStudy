package java_Thread01;

class CutomerInfo {
	static String name;
	static int sum;
	
	public CutomerInfo(String name, int sum) {
		this.name = name;
		this.sum = sum;
	}
	
	public Account()
}//°í°´ Á¤º¸ Å¬·¡½º 

class ThreadBank1 extends Thread{

	public void run() {
		System.out.println("1st °í°´ ÀÔÀå");
	}
}//1¹ø ¼Õ´Ô Å¬·¡½º 

class ThreadBank2 extends Thread{

	public void run() {
		System.out.println("2nd °í°´ ÀÔÀå");
	}
	
}//2¹ø ¼Õ´Ô Å¬·¡½º 

public class ThreadMainClass6 {

	public static void main(String[] args) {
		CutomerInfo ci1=new CutomerInfo("Á¤ÀºÁÖ",300);
		CutomerInfo ci2=new CutomerInfo("¼­¿ø±¹",500);
		
		ThreadBank1 tb1=new ThreadBank1();
		ThreadBank2 tb2=new ThreadBank2();
		
		tb1.start();
		tb2.start();
		
	}

}
