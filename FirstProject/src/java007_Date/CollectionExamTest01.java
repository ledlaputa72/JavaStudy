package java007_Date;

import java.util.*;

//Ŭ���� 
class SMarket1{ 
	private String sangpum;
	private int price;
	private String wichi;

	public SMarket1() { //default ������
		
	}
	
	public SMarket1(String sangpum, int price, String wichi) { //������
		super();
		this.sangpum = sangpum;
		this.price = price;
		this.wichi = wichi;
	}
	
	//getter setter
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWichi() {
		return wichi;
	}
	public void setWichi(String wichi) {
		this.wichi = wichi;
	}
	
	/*
	@Override //�ڵ����� ������ toString, @Override�� �ڵ����� �����Ǿ����� ��Ÿ����. 
	public String toString() {
		return "SMarket1 [sangpum=" + sangpum + ", price=" + price + ", wichi=" + wichi + "]";
	}
	*/	
	
	//toString ��� �޼ҵ�
	public String toString() {
		return "��ǰ�̸��� "+sangpum+"�̰�, ������ "+price+"�̰�, ��ǰ�� �Ŵ� ��ġ�� "+wichi+"�Դϴ�.";
	}
	
} //SMarket class end


public class CollectionExamTest01 {

	public static void main(String[] args) {

		//ArrayList�� ���� �־�� �Ѵ�.
		ArrayList<SMarket1> arr1=new ArrayList<SMarket1>();
		
		//.add�� ���� ���� �Է� 
		arr1.add(new SMarket1("����Ʈ",2000,"A")); //���� ������ .add
		//System.out.println(arr1.get(0)); //������ .get
		arr1.add(new SMarket1("�������",2500,"A"));
		arr1.add(new SMarket1("��Ƽ���",3500,"A"));
		arr1.add(new SMarket1("�̿�",2000,"A"));
		arr1.add(new SMarket1("���Ͽ���",2300,"A"));
		arr1.add(new SMarket1("�������",2300,"A"));
		arr1.add(new SMarket1("����ġ��",4000,"B"));
		arr1.add(new SMarket1("��ī�ݶ�",1500,"C"));
		arr1.add(new SMarket1("��������Ʈ",1400,"C"));
		arr1.add(new SMarket1("��Ű��Ʈ",4500,"D"));
		
		System.out.println("=================��ϵ� ��ǰ��===================");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
		//�˻�
		//������ 3500�� �̻��� ���� ��� ����Ͻÿ� 
		System.out.print("�˻��� ��ǰ���� �Է��ϼ��� : ");
 		
 		Scanner sc=new Scanner(System.in);
 		String sc1=sc.next();
	
		System.out.println("==============3500�� �̻��� ��ǰ��=================");
		for (int i = 0; i < arr1.size(); i++) {
				if (sc1.equals(arr1.get(i).getSangpum())) {
					System.out.println("�˻��� ��ǰ�� "+arr1.get(i));
					System.out.print("�̸��� �����ϼ��� : ");
					String sc11=sc.next();
					System.out.print("������ �����ϼ��� : ");
					int sc12=sc.nextInt();
					System.out.print("�Ŵ븦 �����ϼ��� : ");
					String sc13=sc.next();
					
					arr1.set(i, new SMarket1(sc11, sc12, sc13));
					System.out.println("������ "+arr1.get(i));
				}
			}
		
	}// main end

}//class end
