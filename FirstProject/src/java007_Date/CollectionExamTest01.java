package java007_Date;

import java.util.*;

//SMarket1 Ŭ����////////////////////////////////////////////////////// 
class SMarket1{ 
	private String sangpum;
	private int price;
	private String wichi;
	
	//default ������////////////////////////////////////////////////////
	public SMarket1() {
		
	}
	
	//������//////////////////////////////////////////////////////////
	public SMarket1(String sangpum, int price, String wichi) {
		super();
		this.sangpum = sangpum;
		this.price = price;
		this.wichi = wichi;
	}
	
	//getter setter//////////////////////////////////////////////////
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
	
	//toString ��� �޼ҵ�///////////////////////////////////////////////
	public String toString() {
		return "��ǰ�̸��� "+sangpum+"�̰�, ������ "+price+"�̰�, ��ǰ�� �Ŵ� ��ġ�� "+wichi+"�Դϴ�.";
	}
	
} //SMarket class end


public class CollectionExamTest01 {

	public static void main(String[] args) {

		//ArrayList�� ���� �־�� �Ѵ�./////////////////////////////////////
		ArrayList<SMarket1> arr1=new ArrayList<SMarket1>();
		
		//.add�� ���� ���� �Է� ////////////////////////////////////////////
		arr1.add(new SMarket1("����Ʈ",2000,"A")); //���� ������ .add
		arr1.add(new SMarket1("�������",2500,"A"));
		arr1.add(new SMarket1("��Ƽ���",3500,"A"));
		arr1.add(new SMarket1("�̿�",2000,"A"));
		arr1.add(new SMarket1("���Ͽ���",2300,"A"));
		arr1.add(new SMarket1("�������",2300,"A"));
		arr1.add(new SMarket1("����ġ��",4000,"B"));
		arr1.add(new SMarket1("��ī�ݶ�",1500,"C"));
		arr1.add(new SMarket1("��������Ʈ",1400,"C"));
		arr1.add(new SMarket1("��Ű��Ʈ",4500,"D"));
		
		//���ϵ� ��ǰ ���////////////////////////////////////////////////
		System.out.println("=================��ϵ� ��ǰ��===================");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));//������ .get
		}
		
		/*//�˻�
		//������ 3500�� �̻��� ���� ��� ����Ͻÿ� 
		for (int i = 0; i < arr1.size(); i++) {
		    if (arr1.get(i).getPrice() >=3500) {
		          System.out.println(arr1.get(i));
		    }
		} */
        
        //�Է¿� ���� �˻� ���////////////////////////////////////////////
		System.out.print("�˻��� ������ �Է��ϼ��� : ");
		
		//�Է�
		Scanner sc=new Scanner(System.in);
		int ka=Integer.parseInt(sc.next());
		
		//�޼ҵ带 ����ؼ� ���ڸ� ������ ��ȯ ���� /////////////////////////////////
		ArrayList<SMarket1> arr2=new ArrayList<SMarket1>(); //kaja��ȯ ���� �ޱ� ���� arr2
		arr2=kaja(arr1,ka); //arr1�� ȸ�� �ǵ� �������� arr1�� �ؾ��ϳ�. �ȱ׷��� ���� ����� ����Ѵ�.
		
		//�˻��� ��� ���
		System.out.println("=================�˻��� ��ǰ��===================");
		for (int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i));//������ .get
		}
		
	}// main end

	//���ڸ� �޾� �˻��ϰ� ��ȯ�ϴ� �޼ҵ�////////////////////////////////////////
	private static ArrayList<SMarket1> kaja(ArrayList<SMarket1> arr1, int ka) {
		ArrayList <SMarket1> arr2= new ArrayList<SMarket1>(); //�޼ҵ忡�� ���� ����� ��� �׸�
		
			for (int i = 0; i < arr1.size(); i++) {
				if (arr1.get(i).getPrice() >= ka) {
					arr2.add(arr1.get(i)); //�˻��� ���� arr2�� �ִ´�. 
				}
			}
			return arr2; //arr2�� ��ȯ�Ѵ�. 
	}

}//class end
