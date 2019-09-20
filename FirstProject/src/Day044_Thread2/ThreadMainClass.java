package Day044_Thread2;

class CustomerInfo {
	private String name;
	private int sum;
	//������
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
	
	//���
	public int chool(int sum) {
		this.sum -= sum;
		System.out.println(name+"���� ��� -----�ݾ� : "+sum);
		return sum;
	}
	//�Ա�
	public int ip(int janaek) {
		this.sum += janaek;
		System.out.println(name+"���� ��� +++++�ݾ� : "+janaek);
		return janaek;
	}

	@Override
	public String toString() {
		return name+"���� �ܾ��� "+getSum() + "���Դϴ�.";
	}
	
}//�� ���� Ŭ���� 

//1�� �մ� 
class ThreadBank1 extends Thread{
	
	public void run() {
		System.out.println("1st �մ� ���� "); 
		CustomerInfo cf1=new CustomerInfo("������",500); //��ü ������ run()�ȿ��� 
		System.out.println(cf1);
		cf1.chool(300);
		System.out.println(cf1);
		cf1.ip(200);
		System.out.println(cf1);
		System.out.println(cf1.getName()+"���� �����ϴ�.");
	}
}//1�� �մ� Ŭ���� 

// 2�� �մ� 
class ThreadBank2 extends Thread{

	public void run() {
		System.out.println("2nd �մ� ���� ");
		CustomerInfo cf2=new CustomerInfo("������",300);
		System.out.println(cf2);
		cf2.chool(500);
		System.out.println(cf2);
		cf2.ip(100);
		System.out.println(cf2);
		System.out.println(cf2.getName()+"���� �����ϴ�.");
	}
	
}//2�� �մ� Ŭ���� 

public class ThreadMainClass {

	public static void main(String[] args) {
		
		ThreadBank1 tb1=new ThreadBank1();
		ThreadBank2 tb2=new ThreadBank2();
		
		tb1.start();
		tb2.start();
		
	}

}

