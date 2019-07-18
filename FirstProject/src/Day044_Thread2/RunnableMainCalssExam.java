package Day044_Thread2;

class Account2{
	private String kokaek; //��
	private int janaek; //�ܾ�
	
	//������
	public Account2(String kokaek, int janaek) {
		super();
		this.kokaek = kokaek;
		this.janaek = janaek;
	}
	
	public Account2(int janaek){
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
class Bank01 implements Runnable{
	
	public Bank01() {
		
	}
	
	Account2 ac1=new Account2("������",300); //�ʱ�ġ
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
class Bank02 implements Runnable{
	
	public Bank02() {
		
	}
	
	Account2 ac2=new Account2("������",500); //�ʱ�ġ
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


public class RunnableMainCalssExam {

	public static void main(String[] args) {

		Thread b01=new Thread(new Bank01());
		Thread b02=new Thread(new Bank02());
		
		 b01.start();
		 b02.start();
		
	}

}
