package java001;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {

		Scanner sc1= new Scanner(System.in);
		
//		// �޴��� ������ ���α׷� 
//		int menu=0;
//		
//		do {
//			System.out.println("�߱����� ���Ű��� ȯ���մϴ�. ");
//			System.out.println("1.¥��");
//			System.out.println("2.¬��");
//			
//			System.out.println("���Ͻô� �޴��� ������");
//			int food1=sc1.nextInt();
//			
//			if(food1==1) {
//				System.out.println("1.¥��, ���ְ� �弼�� ");
//				menu=1;
//			}
//			else if(food1==2) {
//				System.out.println("2.«��, ���ְ� �弼��");
//				menu=1;
//			}
//			else {
//			}
//
//		} while (menu==0);
		
		
//		// ������ Ǯ�� 
//		int sun1;
//		do {
//			System.out.println("1.¥��");
//			System.out.println("2.¬��");
//			sun1=Integer.parseInt(sc1.next()); // nextInt�� �ݺ��Ǹ� ������ �߻��ؼ� char�� �޾� int�� ��ȯ�Ѵ�. 
//		} while(sun1!=1 && sun1!=2); //1 or 2�� �ݴ� --> !1 && !2
//		
//		System.out.println("���ְ� �弼��");
		
		/*
		// ###########################
		// int ��� string ����  �Է¹޾� ó�� --> �Ʒ��� ���� �ȳ��� (���� �߻�)
		String sun1; //
		do {
			System.out.println("1.¥��");
			System.out.println("2.¬��");
			sun1=sc1.next(); //
			System.out.println(sun1);
		} while(sun1!="1" && sun1!="2");
		
		System.out.println("���ְ� �弼��");
		
		//#######################
		// int ��� String �Է� �ޱ� ���� 
		String aa="ondal"; //Stack aa(1000�� �ּ�) -> heap 1000 ("ondal")
		String bb="ondal"; //Stack bb(2000�� �ּ�) -> heap 2000 ("ondal")�� ������ �ʰ�, 
							//�̹� �ִ� heap1000("ondal")�� ����ؼ� Stack bb(1000�� �ּ�)�� ����Ѵ�. 
							// aa�� bb�� heap�� ������ ����, ���� ����. 
		if(aa==bb) { // ������ ����. ���� ��
			System.out.println("==����");
		}
		if(aa.equals(bb)) { // �Լ�, �޼ҵ� , ���� ����. �� ��
			System.out.println("equals ����");
		}
		// ������ ���� ��� ����. 
		
		//#########################
		// ���� Ʋ����� 
		String aa2="ondal1";  
		String bb2="ondal2";  // ���� Ʋ����. 
		
		if(aa2==bb2) { // ���� �� 
			System.out.println("==����");
		}
		if(aa2.equals(bb2)) { // �� ��
			System.out.println("equals ����");
		}
		// ������ ���� ��� Ʋ����. 
		
		
		//##############################
		// String cc="ondal";
		String cc=new String("ondal");
		String dd=new String("ondal"); // ������ Ʋ������ ���� ���� 
		if(cc==dd) {
			System.out.println("cc==dd����");
		}
		if(cc.equals(dd)) {
			System.out.println("cc.eqauls(dd)����");
		}
		// ���� ����. 
		*/
		
		// int ��� string ����  �Է¹޾� ó�� --> �Ʒ��� ���� �ȳ��� 
		String sun2; //
		do {
			System.out.println("1.¥��");
			System.out.println("2.¬��");
			sun2=sc1.next(); //
		} while(!sun2.equals("1") && !sun2.equals("2")); //������ ��
		System.out.println("���ְ� �弼��");
		//������ Ʋ������ ���� �����Ƿ� 
		
		
	}

}
