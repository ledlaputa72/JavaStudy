import java.util.Scanner;

public class DataType {

	public static void main(String[] args) {
/*		
		  int aa=100; System.out.println(aa);		  
		  short bb=200; System.out.println(bb);
		  byte cc=10; System.out.println(cc);
		  long dd=12012344123L; System.out.println(dd);
		  double ee=1231.233; System.out.println(ee);
		  float ff=123.34f; System.out.println(ff);
		  boolean gg=true; System.out.println(gg);
		  char hh='A'; System.out.println(hh);		  
		  String str="ondal"; 
		  
		  System.out.println(str);
*/		  
		
/*
		  int a1=50;		  
		  int a2=70;
		  int a3=a1+a2; 
		  //a3=50+70�� ����, =�� �ǹ� 1)����(�� -> �·�), 2)����
		  int a4=a3*1000; 
		  // ������ �� ���ϱ�
		  
		  System.out.println("��� ����� "+a3+" , "+a4);
		  
		  //�ڹٿ��� +�� �ٿ��ش�.���� : ��� ����� 120 ,120000
*/

		  // #����) �޿����� �����Դ� ���������� �������� 17%��� �Ҷ�, �޿����� �����Ը� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
		  /*
		  int mom=85; // �� ������
		  
		  float moon=0.17f; // ���� ��� 1) ���� ���� ���� 17%, ��¿��� ���
		  System.out.println("�� ������ = "+mom+"Ű�α׷�, �޿��� ������ ="+(mom*moon)+"Ű�α׷�");
		  
		  double dalmom=mom*0.17; // ���� ��� 2) ������ ����� �Ͽ� ���
		  System.out.println("�� ������ = "+mom+"Ű�α׷�, �޿��� ������ ="+(dalmom)+"Ű�α׷�");
		  */
		
		// ����2
		/*
		int a=10;
		int b=7;
		double c=(a*b)/2;
		
		System.out.println("�غ�="+a+", ����="+b+" �϶�, �ﰢ���� ���̴� "+c+"�̴�");
		*/
		
		//���� 3 
		// double cel=22; //���� �µ�
		
		
		Scanner sc1= new Scanner(System.in); // Ű���� �Է�
		
		System.out.print("�̸��� �Է��ϼ���.: ");
		String name = sc1.next();
		
		System.out.print("���� �µ��� �Է��ϼ���.: ");
		double cel = sc1.nextDouble();
		
		double fah=(cel*9/5)+32; //ȭ���� ���ϴ� ���� 
		
		System.out.println(name+"�� �ݰ����ϴ�.");
		System.out.println("�µ� ��ȭ : ����="+cel+"�� �϶�, ȭ��="+fah+"�� �Դϴ�.");
		
		
		
	}

}










