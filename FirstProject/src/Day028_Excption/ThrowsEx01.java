package Day028_Excption;

import java.util.Scanner;

public class ThrowsEx01 {

	public static void main(String[] args) {
		try {
		Scanner sc1=new Scanner(System.in);
		
		System.out.print("ù��°���� : ");
		String one2=sc1.nextLine();
		int soo1=Integer.parseInt(one2);
		
		System.out.print("�ι�°���� : ");
		String two2=sc1.nextLine();
		int soo2=Integer.parseInt(two2);
		
		int bada=kaja(soo1,soo2);
		System.out.println(bada);
		}catch(Exception e) {
			System.out.println("���⼭ ���� ó���Ѵ�. ");
		}
	}//main end
	
	//Throw ����
	/*private static int kaja(int soo1, int soo2) {
		//soo1/soo2 �Ҷ� ������ ���ֳ� soo2(�и�)�� ���� üũ
		if(soo2==0) {
			System.out.println("0���� ������ ����. ");
			throw new ArithmeticException();
		}
		else
			return soo1/soo2;
	}//kaja end
	*/
	
	//throws ����
	private static int kaja(int soo1, int soo2) 
		throws ArithmeticException{
			return soo1/soo2;
		}//kaja end
	
}//class end
