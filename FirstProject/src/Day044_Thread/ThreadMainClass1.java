package Day044_Thread;

class Account{
	private String kokaek; //고객
	private int janaek; //잔액
	
	//생성자
	public Account(String kokaek, int janaek) {
		super();
		this.kokaek = kokaek;
		this.janaek = janaek;
	}
	
	public Account(int janaek){
		this.janaek=janaek;
	}

	//getter setter
	public String getKokaek() {
		return kokaek;
	}

	public void setKokaek(String kokaek) {
		this.kokaek = kokaek;
	}

	public int getJanaek() {
		return janaek;
	}

	public void setJanaek(int janaek) {
		this.janaek = janaek;
	}
	
	//출금
	public int chool(int janaek) {
		this.janaek -= janaek;
		System.out.println(kokaek+"님의 출금 -----금액 : "+janaek);
		return janaek;
	}
	//입금
	public int ip(int janaek) {
		this.janaek += janaek;
		System.out.println(kokaek+"님의 출금 +++++금액 : "+janaek);
		return janaek;
	}

	@Override
	public String toString() {
		return kokaek+"님의 잔액은 "+getJanaek() + "원입니다.";
	}
	
} //Account end

//Thread 1 class///////////////////
class ThreadClass61 extends Thread{
	Account ac1=new Account("정은주",300); //초기치
	public void run() {
		System.out.println("1st 고객입장");
//		Account ac1=new Account("정은주",300); //초기치
		System.out.println(ac1);
		ac1.chool(100);//출금
		System.out.println(ac1);
		ac1.ip(500);
		System.out.println(ac1);
		System.out.println("1st 고객 은행을 나간다.");
	}
	
} //ThreadClass61 end

//Thread 2 class/////////////////
class ThreadClass62 extends Thread{
	Account ac2=new Account("서원국",500); //초기치
	public void run() {
		System.out.println("2nd 고객입장");
//		Account ac2=new Account("서원국",500); //초기치
		System.out.println(ac2);
		ac2.chool(300);//출금
		System.out.println(ac2);
		ac2.ip(100);
		System.out.println(ac2);
		System.out.println("2nd 고객 은행을 나간다.");
	}
} //ThreadClass62 end

public class ThreadMainClass1 {

	public static void main(String[] args) {
		
		ThreadClass61 tc61=new ThreadClass61();
		ThreadClass62 tc62=new ThreadClass62();
		
		tc61.start();
		tc62.start();
	}

}
