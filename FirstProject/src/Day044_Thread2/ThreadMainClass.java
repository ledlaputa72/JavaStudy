package Day044_Thread2;

class CustomerInfo {
	private String name;
	private int sum;
	//생성자
	public CustomerInfo(String name, int sum) {
		this.name = name;
		this.sum = sum;
	}
	
	public CustomerInfo(int sum) {
		this.sum = sum;
	}

	//getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	//출금
	public int chool(int sum) {
		this.sum -= sum;
		System.out.println(name+"님의 출금 -----금액 : "+sum);
		return sum;
	}
	//입금
	public int ip(int janaek) {
		this.sum += janaek;
		System.out.println(name+"님의 출금 +++++금액 : "+janaek);
		return janaek;
	}

	@Override
	public String toString() {
		return name+"님의 잔액은 "+getSum() + "원입니다.";
	}
	
}//고객 정보 클래스 

//1번 손님 
class ThreadBank1 extends Thread{
	
	public void run() {
		System.out.println("1st 손님 입장 "); 
		CustomerInfo cf1=new CustomerInfo("정연섭",500); //객체 생성이 run()안에서 
		System.out.println(cf1);
		cf1.chool(300);
		System.out.println(cf1);
		cf1.ip(200);
		System.out.println(cf1);
		System.out.println(cf1.getName()+"님이 나갑니다.");
	}
}//1번 손님 클래스 

// 2번 손님 
class ThreadBank2 extends Thread{

	public void run() {
		System.out.println("2nd 손님 입장 ");
		CustomerInfo cf2=new CustomerInfo("정제이",300);
		System.out.println(cf2);
		cf2.chool(500);
		System.out.println(cf2);
		cf2.ip(100);
		System.out.println(cf2);
		System.out.println(cf2.getName()+"님이 나갑니다.");
	}
	
}//2번 손님 클래스 

public class ThreadMainClass {

	public static void main(String[] args) {
		
		ThreadBank1 tb1=new ThreadBank1();
		ThreadBank2 tb2=new ThreadBank2();
		
		tb1.start();
		tb2.start();
		
	}

}

