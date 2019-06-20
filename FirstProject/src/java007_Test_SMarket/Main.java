package java007_Test_SMarket;

import java.util.*;

//SMarket Ŭ���� 
class SMarket{
	private String name; //��ǰ ��
	private int price; //��ǰ ����
	private String counter; //�Ŵ� ��ġ 
	
	//default ������ ////////////////////////////////
	public SMarket() { 
		super();
	}
	
	//������////////////////////////////////////////
	public SMarket(String name, int price,  String counter) {
		super();
		this.name = name;
		this.price = price;
		this.counter = counter;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	//���
	@Override
	public String toString() {
		return "SMarket [name=" + name + ", price=" + price + ", counter=" + counter + "]";
	}
	
}// SMarket end


public class Main {

	public static void main(String[] args) {
		//do while Menu & switch
		//��ȣ ���� 
		Scanner sc=new Scanner(System.in);
		
		//��ǰ�� �Է��� ���� �÷��� ����Ʈ 
		ArrayList<SMarket> arr1=new ArrayList<SMarket>(); //
		
		 arr1.add(new SMarket("�������",2500,"A"));
         arr1.add(new SMarket("��Ƽ���",3000,"A"));
         arr1.add(new SMarket("�̿�",2000,"A"));
         arr1.add(new SMarket("���Ͽ���",2300,"A"));
         arr1.add(new SMarket("�������",2300,"A"));
         arr1.add(new SMarket("����ġ��",4000,"B"));
         arr1.add(new SMarket("��ī�ݶ�",1500,"C"));
         arr1.add(new SMarket("��������Ʈ",1400,"C"));
         arr1.add(new SMarket("��Ű��Ʈ",4500,"D"));
        
         for (int i = 0; i < arr1.size(); i++) {
             System.out.println(arr1.get(i));
        }
		
		//�޴� ���α׷�
		int selectMenu;
		do {
			System.out.println("==== SMarket ���� ���α׷� �޴� ====");
			System.out.println("1) ��ǰ �Է�");
			System.out.println("2) ��ǰ ����");
			System.out.println("3) ��ǰ �˻�");
			System.out.println("4) ��ǰ ����");
			System.out.println("5) ����");
			System.out.println("�����ϼ��� (1-5)");
			
			//��ȣ�� �Է� �޴´�. 
			selectMenu=sc.nextInt();
			
			switch (selectMenu) {
			case 1:
				kajaCreate(arr1);
				break;
			case 2:
				kajaUpdate(arr1);
				break;
			case 3:
				kajaSearch(arr1);
				break;
			case 4:
				kajaDelete(arr1);
				break;
			case 5:
				
				break;
			default:
				break;
			}
		} while (selectMenu!=1 && selectMenu!=2 && selectMenu!=3 && selectMenu!=4&& selectMenu!=5);
		
		//4) ���� 

	} //main end
	
	//1) ��ǰ �Է� �޼ҵ�///////////////////////////////////////
	private static void kajaCreate(ArrayList<SMarket> arr1) {
		System.out.println("��ǰ �Է�");
		
		System.out.println("-----------��ǰ�� �Է��ϼ��� -------------");
		

	}

	//2) ��ǰ ���� �޼ҵ�/////////////////////////////////////////
	private static void kajaUpdate(ArrayList<SMarket> arr1) {
		System.out.println("��ǰ ����");
		
		System.out.println("-----------������ �Է��ϼ��� -------------");
		
	}

	//3) ��ǰ �˻� �޼ҵ�////////////////////////////////////////
	private static void kajaSearch(ArrayList<SMarket> arr1) {
		System.out.println("--------------��ǰ �˻�----------------");
		System.out.println("�˻��� ��ǰ���� �Է��ϼ��� ");
		Scanner sc=new Scanner(System.in);
		
		//�˻�ã�� 
		for (int i = 0; i < arr1.size(); i++) {
			if (arr1.get(i).getName()==sc.next()) { //�Է��� �ܾ ã�Ƽ� ������ ���
				System.out.println(arr1.get(i));
			}
		}
		
		System.out.println("�˻��� ��Ĩ�ϴ�. ");
		
	}
	//4) ��ǰ ���� �޼ҵ�//////////////////////////////////////////////
	private static void kajaDelete(ArrayList<SMarket> arr1) {
		System.out.println("��ǰ ����");
		
	}

}//class end
