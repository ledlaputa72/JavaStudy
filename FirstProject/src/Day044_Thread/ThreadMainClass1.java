package Day044_Thread;

class Account{
	private String kokaek; //��
	private int janaek; //�ܾ�
	
	//������
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
	
	//���
	public int chool(int janaek) {
		this.janaek -= janaek;
		System.out.println(kokaek+"���� ��� -----�ݾ� : "+janaek);
		return janaek;
	}
	//�Ա�
	public int ip(int janaek) {
		this.janaek += janaek;
		System.out.println(kokaek+"���� ��� +++++�ݾ� : "+janaek);
		return janaek;
	}

	@Override
	public String toString() {
		return kokaek+"���� �ܾ��� "+getJanaek() + "���Դϴ�.";
	}
	
} //Account end

//Thread 1 class///////////////////
class ThreadClass61 extends Thread{
	Account ac1=new Account("������",300); //�ʱ�ġ
	public void run() {
		System.out.println("1st ������");
//		Account ac1=new Account("������",300); //�ʱ�ġ
		System.out.println(ac1);
		ac1.chool(100);//���
		System.out.println(ac1);
		ac1.ip(500);
		System.out.println(ac1);
		System.out.println("1st �� ������ ������.");
	}
	
} //ThreadClass61 end

//Thread 2 class/////////////////
class ThreadClass62 extends Thread{
	Account ac2=new Account("������",500); //�ʱ�ġ
	public void run() {
		System.out.println("2nd ������");
//		Account ac2=new Account("������",500); //�ʱ�ġ
		System.out.println(ac2);
		ac2.chool(300);//���
		System.out.println(ac2);
		ac2.ip(100);
		System.out.println(ac2);
		System.out.println("2nd �� ������ ������.");
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
