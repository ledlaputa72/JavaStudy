package Java011_Test;

import java.util.*;

class Market{
	private String s_Name;
	private int s_Price;
	private int s_In;
	private int s_Out;
	
	//������
	public Market() {
		super();
	}
	
	public Market(String s_Name, int s_Price, int s_In, int s_Out) {
		super();
		this.s_Name = s_Name;
		this.s_Price = s_Price;
		this.s_In = s_In;
		this.s_Out = s_Out;
	}
	
	//setter getter
	public String getS_Name() {
		return s_Name;
	}
	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}
	public int getS_Price() {
		return s_Price;
	}
	public void setS_Price(int s_Price) {
		this.s_Price = s_Price;
	}
	public int getS_In() {
		return s_In;
	}
	public void setS_In(int s_In) {
		this.s_In = s_In;
	}
	public int getS_Out() {
		return s_Out;
	}
	public void setS_Out(int s_Out) {
		this.s_Out = s_Out;
	}

	//���
	@Override
	public String toString() {
		return "��ǰ�̸��� "+this.getS_Name() + ", ������ "+this.getS_Price()+", �԰��� "+this.getS_In()+", �����"+this.getS_Out()+"�Դϴ�.";
	}
	
}//Market class end

public class ExamTest03 {

	public static void main(String[] args) {
		
		//1-1.�Ϲ� �� ���� �Է�
		Market m1=new Market();
		m1.setS_Name("����");
		m1.setS_Price(1200);
		m1.setS_In(500);
		m1.setS_Out(300);

		System.out.println("�Ϲ� �迭�� 1-1 ----------------------------------------");
//		System.out.println(m1.toString());
		for (int i = 0; i < args.length; i++) {
			System.out.println(m1);
		}
		
		//1-2.�Ϲ� ��ü �ѹ��� �Է� 
		Market m2=new Market("��",500,1000,400);
		
		System.out.println("�Ϲ� �迭�� 1-2 ----------------------------------------");
		System.out.println(m2.toString());
		
		//2.Generic Collection���� ����
		ArrayList<Market> arr1=new ArrayList<Market>();
		
		arr1.add(new Market("����",700,300,250));
		arr1.add(new Market("�꽺",1000,1300,250));
		arr1.add(new Market("���ݷ�",2000,400,150));
		arr1.add(new Market("���ڻ�",1700,200,50));
		arr1.add(new Market("���û�",900,700,150));
		
		System.out.println("�÷�������  --------------------------------------------");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
		System.out.println("�÷��ǿ��� ��ǰ�� �԰� - ��� ------------------------------");
		for (int i = 0; i < arr1.size(); i++) {
			int in=arr1.get(i).getS_In();
			int out=arr1.get(i).getS_Out();
			int div=in-out;
			if (div>out) {
				System.out.println("�԰�"+in+"-���"+out+"="+div+"�Դϴ�.");
			}	
		}
		
		System.out.println("�÷��ǿ��� �˻�------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("�˻��̸��� : ");
		String sc1=sc.next();
		for (int i = 0; i < arr1.size(); i++) {
			if (sc1.equals(arr1.get(i).getS_Name())) {
				System.out.println(arr1.get(i));
			}
		}
		
	}

}
