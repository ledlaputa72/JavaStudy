package Day016_Method_Overload;

import java.util.Scanner;

public class MethodTest2 {

	public static void main(String[] args) {
		// �޼ҵ�
		double ki=kaja1(); // Ű�Է� �ޱ� 
		double mom=kaja2(); // ������ �Է� �ޱ� 
		int bmi=(int)kaja3(ki, mom); // BMI ����ϱ�
        String printBmi=kaja4(bmi); // BMI�� ��� ���� �����
        //��� ��¹� 
		System.out.println("����� �����Դ� "+mom+"kg�̸�, ����� Ű�� "+(ki*100)+"cm�Դϴ�.");
		System.out.println("����� BMI��ġ�� "+bmi+" �Դϴ�.");
        System.out.println("����� BMI�� "+printBmi+" �Դϴ�.");  // ���� ��� ����ϱ� 
	}
	
	// BMI ��� �޼ҵ�
	private static String kaja4(double bmi) {
		
		String result; 
		if ( 30<= bmi) {
			result = "��";
       }
       else if (25 <= bmi && bmi < 30)
       {
    	   result = "��ü��";
       }
       else if(20 <= bmi && bmi < 25 )
       {
    	   result = "����";
       }
       else
       {
    	   result = "��ü�� ";
       }
		return result;
	}
	
	// BMI ��� �޼ҵ�
	private static double kaja3(double ki, double mom) {
		 double bmi = mom / (ki*ki); // mom / Math.pow(ki, 2); pow()�Լ� = power(����)�� �ǹ�
		 return bmi;
	}

	// ������ �Է� �޼ҵ�
	private static double kaja2() {  
		Scanner sc1 = new Scanner(System.in);

		System.out.println("����� �����Ը� �Է��ϼ��� : ");
        double ki= sc1.nextFloat();
        return ki;
	}
	
	// Ű �Է� �޼ҵ�
	private static double kaja1() {  
		Scanner sc2 = new Scanner(System.in);

		System.out.println("����� Ű�� ���ͷ� �Է��ϼ��� : ");
        double mom= (sc2.nextFloat()/100);
        return mom;
	}
}
