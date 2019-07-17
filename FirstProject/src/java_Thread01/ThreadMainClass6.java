package java_Thread01;

class CutomerInfo {
	static String name="Jone";
	static int sum=100;
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		CutomerInfo.name = name;
	}
	public static int getSum() {
		return sum;
	}
	public static void setSum(int sum) {
		CutomerInfo.sum = sum;
	}
	
	public void Account(String name, int sum) {
		System.out.println(name+" + "+sum);
	}
	
	public void Output(String name, int sum) {
		System.out.println(name+" ---------- "+ 200);
		sum = sum -200;
	}
	
	
}//°í°´ Á¤º¸ Å¬·¡½º 

//1¹ø ¼Õ´Ô 
class ThreadBank1 extends Thread{
	CutomerInfo cf1=new CutomerInfo();
	
	public void run() {
		System.out.println("1st ¼Õ´Ô ÀÔÀå "); 
		cf1.setName("Tom");
		cf1.setSum(500);
		cf1.Account(cf1.getName(),cf1.getSum());
		cf1.Output(cf1.getName(),cf1.getSum());
		cf1.Account(cf1.getName(),cf1.getSum());

		
	}
}//1¹ø ¼Õ´Ô Å¬·¡½º 

// 2¹ø ¼Õ´Ô 
class ThreadBank2 extends Thread{
	CutomerInfo cf2=new CutomerInfo();
	
	public void run() {
		System.out.println("2nd ¼Õ´Ô ÀÔÀå ");
		cf2.setName("Jay");
		cf2.setSum(1000);
		cf2.Account(cf2.getName(),cf2.getSum());
		cf2.Output(cf2.getName(),cf2.getSum());
		cf2.Account(cf2.getName(),cf2.getSum());
	}
	
}//2¹ø ¼Õ´Ô Å¬·¡½º 

public class ThreadMainClass6 {

	public static void main(String[] args) {
		CutomerInfo ci1=new CutomerInfo();
		
		ThreadBank1 tb1=new ThreadBank1();
		ThreadBank2 tb2=new ThreadBank2();
		
		tb1.start();
		tb2.start();
		
	}

}
