package Day028_Excption;

import java.util.Scanner;

public class ExcptionEx01 {

	public static void main(String[] args) {
		
		try { ///////////////////////////////////
		Scanner sc1=new Scanner(System.in);
		
		System.out.print("ù��°���� : ");
		String one1=sc1.nextLine();
		int soo1=Integer.parseInt(one1);
		// int soo1=sc1.nextInt();�� �޾Ƶ� ������ �������� ���� ������ ���� Strig->int(feat, paraseInt)���ش�.
		
		System.out.print("ù��°���� : ");
		String two1=sc1.nextLine();
		int soo2=Integer.parseInt(two1);
		
		/*
	 	//main args�� Ȱ���� ����
		int soo1=Integer.parseInt(args[0]);
		int soo2=Integer.parseInt(args[1]);
		*/
		
		System.out.println(soo1/soo2);
		
		}catch(ArithmeticException e){ // ���� ���� ���� 
			System.out.println("0�� �ƴ� �ΰ��� ������ �Է��Ͻÿ�");
		}catch(ArrayIndexOutOfBoundsException e){ // ���� ���� ó���� ���� ����
			System.out.println("2���� ���� �Է��Ͻÿ�");
		}catch(NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���");
		}catch(Exception e) {////���� ó�� ����
			System.out.println("�׹��� ���ܸ� ó���մϴ�. ");
			System.out.println(e); //.toString())
			System.out.println(e.getMessage());
			//c��� : errno�濡 4069�� �� : message
		}
		finally { // ���� ����
			System.out.println("����� ������ ����");
		}

	}

}
