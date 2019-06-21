package java007_Test_SMarket;

import java.util.*;

//SMarket Ŭ���� ////////////////////////////////////////
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
	
	//getter setter///////////////////////////////
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

	//���//////////////////////////////////////////////////
	@Override
	public String toString() {
		return "[��ǰ�� : " + name +"\t"+ "| ���� : " + price +"\t"+ "| �Ŵ� : " + counter+" ]";
	}
	
}// SMarket end

//main Ŭ���� ////////////////////////////////////////////
public class Main {

	public static void main(String[] args) {
		//�޴� ��ȣ ���� 
		Scanner sc=new Scanner(System.in);
		
		//��ǰ�� �Է��� ���� �÷��� ����Ʈ 
		ArrayList<SMarket> arr1=new ArrayList<SMarket>(); //
		
		//�Է��� �ʱ� ������
		kajaData(arr1);
         
		//�޴� ���α׷�
		int selectMenu;
		do {
			kajaMenu(); //�޴� ���� 
			
			//��ȣ�� �Է� �޴´�. 
			selectMenu=sc.nextInt();
			
			switch (selectMenu) {
			case 0: //0) ��ü ��ǰ ���� �޼ҵ� 
				kajaList(arr1);
				selectMenu=kajaYes(selectMenu); //�ʱ� �޴� ���� �޼ҵ�			
				break;
			case 1: //1) ��ǰ �Է� �޼ҵ�
				kajaCreate(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 2: //2) ��ǰ ���� �޼ҵ�
				kajaUpdate(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 3: //3) ��ǰ �˻� �޼ҵ�
				kajaSearch(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 4: //4) ��ǰ ���� �޼ҵ�
				kajaDelete(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 5: //5) ���� 
				System.out.println("------------------------------------------");
				System.out.println("���α׷��� �����մϴ�. ");
				System.exit(0);
				break;
			default:
				System.out.println("------------------------------------------");
				System.out.println("������ �߸� �߽��ϴ�. �ٽ��ϼ���");
				System.out.println("------------------------------------------");
			}
		} while (selectMenu!=0 && selectMenu!=1 && selectMenu!=2 && selectMenu!=3 && selectMenu!=4&& selectMenu!=5);
		
	} //main end
	
	
	//�ʱ� �Է� ������ ///////////////////////////////////////
	private static void kajaData(ArrayList<SMarket> arr1) {

		 arr1.add(new SMarket("�������",2500,"A"));
         arr1.add(new SMarket("��Ƽ���",3000,"A"));
         arr1.add(new SMarket("�̿�",2000,"A"));
         arr1.add(new SMarket("���Ͽ���",2300,"A"));
         arr1.add(new SMarket("�������",2300,"A"));
         arr1.add(new SMarket("����ġ��",4000,"B"));
         arr1.add(new SMarket("��ī�ݶ�",1500,"C"));
         arr1.add(new SMarket("��������Ʈ",1400,"C"));
         arr1.add(new SMarket("��Ű��Ʈ",4500,"D"));
		
	}

	//���� �޴� /////////////////////////////////////////////
	private static void kajaMenu() {

		System.out.println("=========== SMarket ���� ���α׷� �޴� ===========");
		System.out.println("0) ��ü ��ǰ ����");
		System.out.println("1) ��ǰ �Է�");
		System.out.println("2) ��ǰ ����");
		System.out.println("3) ��ǰ �˻�");
		System.out.println("4) ��ǰ ����");
		System.out.println("5) ����");
		System.out.println("------------------------------------------");
		System.out.println("\t"+"\t"+"\t"+"�޴��� �����ϼ��� (0-5)");
		System.out.println("==========================================");
		
	}

	//�޴� �̵� �޼ҵ�////////////////////////////////////////
	private static int kajaYes(int selectMenu) {
		Scanner sc=new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("\t"+"\t"+"�޴��� �̵��Ͻðڽ��ϱ�? 1.Yes/2.No");
		int YesOrNo=sc.nextInt();
		if (YesOrNo==1) {
			selectMenu=-1;
		}
		else {
			System.out.println("------------------------------------------");
			System.out.println("���α׷��� �����մϴ�. ");
			selectMenu=sc.nextInt();
			System.exit(0);
		}
		return selectMenu;
		
	}

	//0) ��ü ��ǰ ���� �޼ҵ� ///////////////////////////////////
	private static void kajaList(ArrayList<SMarket> arr1) {
		
		System.out.println("===============  ��ü ��ǰ ����  ===============");
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(arr1.get(i));
       }
//        System.out.println("==========================================");
	}

	//1) ��ǰ �Է� �޼ҵ�///////////////////////////////////////
	private static void kajaCreate(ArrayList<SMarket> arr1) {
		System.out.println("---------------��ǰ�� �Է��ϼ��� ---------------");
		System.out.println("���� �� "+(arr1.size())+"�� �Դϴ�. ");
		
 		Scanner sc=new Scanner(System.in); //�Է� �ޱ� 
 		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String sc11=sc.next();
		System.out.print("������ �Է��ϼ��� : ");
		int sc12=sc.nextInt();
		System.out.print("�Ŵ븦 �Է��ϼ��� : ");
		String sc13=sc.next();
 		
 		arr1.add(new SMarket(sc11, sc12, sc13));//�Է� ���� ���� Ŭ������ �Է� 
 		
 		System.out.println("==========================================");
 		System.out.println("�߰��� ��ǰ�� �����Դϴ�. ");
 		System.out.println(arr1.get(arr1.size()-1));
        System.out.println("���� �� "+(arr1.size())+"�� �Դϴ�. ");
//        System.out.println("==========================================");
           
	}

	//2) ��ǰ ���� �޼ҵ�/////////////////////////////////////////
	private static void kajaUpdate(ArrayList<SMarket> arr1) {
		System.out.println("------------------��ǰ ����------------------");
		System.out.print("�˻��� ��ǰ���� �Է��ϼ��� : ");
 		
 		Scanner sc=new Scanner(System.in);
 		String sc1=sc.next();
 		
 		//�˻�ã�� ������ �׸��� �Է� �޾� ������ 
		for (int i = 0; i < arr1.size(); i++) {
				if (sc1.equals(arr1.get(i).getName())) { //�׸� �˻�
					System.out.println("�˻��� ��ǰ�� ����� �Ʒ��� �����ϴ�.");
					System.out.println(arr1.get(i)); //
					
					System.out.print("�̸��� �����ϼ��� : ");
					String sc11=sc.next();
					System.out.print("������ �����ϼ��� : ");
					int sc12=sc.nextInt();
					System.out.print("�Ŵ븦 �����ϼ��� : ");
					String sc13=sc.next();
					System.out.println("----------------------------------------");
					arr1.set(i, new SMarket(sc11, sc12, sc13));
					System.out.println("������ ��ǰ�� �Ʒ��� �����ϴ�. ");
					System.out.println(arr1.get(i));
			}
		}
//        System.out.println("==========================================");
	} //��ǰ ���� �޼ҵ� end
	
	//3) ��ǰ �˻� �޼ҵ�////////////////////////////////////////
	private static void kajaSearch(ArrayList<SMarket> arr1) {
		System.out.println("------------------��ǰ �˻�-------------------");
		System.out.print("�˻��� ��ǰ���� �Է��ϼ��� : ");
		
		Scanner sc=new Scanner(System.in);
		String sc1=sc.next(); //�Է¹��� ���� String sc1���� 
		
		//�˻�ã�� 
		int sw=0;
		for (int i = 0; i < arr1.size(); i++) {
			if (sc1.equals(arr1.get(i).getName())) { //�׸� �˻�
				System.out.println("�˻��� ��ǰ�� ����� �Ʒ��� �����ϴ�.");
				System.out.println(arr1.get(i)); //
				sw=1;
			}
			else {
				break;
			}
		}
		if (sw==0) {
			System.out.println("!!!!!�˻��� ��ǰ�� ã�� �� �����ϴ�.!!!!! ");
		}
		
		
		
		
	} //��ǰ �˻� �޼ҵ� end
	
	//4) ��ǰ ���� �޼ҵ�//////////////////////////////////////////////
	private static void kajaDelete(ArrayList<SMarket> arr1) {
		System.out.println("--------------��ǰ ����----------------");
		System.out.println("������ ��ǰ���� �Է��ϼ��� ");
		
		Scanner sc=new Scanner(System.in);
		String sc1=sc.next();
		
		//�˻�����
		for (int i = 0; i < arr1.size(); i++) {
			if (sc1.equals(arr1.get(i).getName())) { //�Է��� �ܾ ã�Ƽ� ������ ���
				System.out.println(arr1.get(i));
				System.out.println("���� �Ͻðڽ��ϱ�? [1.Yes/2.No]");
				int YesOrNo=sc.nextInt();
				if (YesOrNo==1) {
					arr1.remove(i); //�ش� ��ǰ�� ���� 
					System.out.println("----------------------------------------");
					System.out.println(sc1+"��ǰ�� �����Ǿ����ϴ�.");
				}
				else {
					System.out.println("----------------------------------------");
					System.out.println("��ҵǾ����ϴ�."); 
					break;
				}
				
			}
		}
	} //kajaDelete end

}//class end
