package java002;

import java.util.Scanner;

public class Test001 {

	public static void main(String[] args) {
		
		int sec=kaja(); //�Է� �ޱ� 
		kaja(sec); //�� ����ϱ� 
	}
	
	//�� ����ϱ� �޼ҵ�
	private static void kaja(int sec) {
		
		int min=sec/60; // �ð��� ���ϱ� ���� ���� ����
		int hr=min/60; // ���� 60���� ���� �ð��� ���Ѵ�. ���� �ð�
		int sec1=sec%60; // ���� ���ϰ� ���� ���� ����. ���� �� 
		int min1=min%60; // �ð��� ���ϰ� ���� ���� ����. ���� ��
		
		System.out.println(sec+"�ʴ� ");
		if (hr==0 && min1!=0) { //�ð��� 0�� ���
			System.out.print(min1+"�� "+sec1+"��");
		}
		else if (hr==0 && min1==0) { // �ð��� ���� 0�� ���
			System.out.print(sec1+"��");
		}
		else { //��� ������ ��� 
			System.out.print(hr+"�ð� "+min1+"�� "+sec1+"��");
		}
		System.out.println("�Դϴ�.");
	}
	
	// �� �Է¹ޱ� �޼ҵ�
	private static int kaja() {
		Scanner sc1= new Scanner(System.in);
		
		System.out.println("�ʸ� �Է��ϼ���");
		int sec1=sc1.nextInt();
		return sec1;
	}

}
