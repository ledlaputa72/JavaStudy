package Day028_Excption;

import java.util.Scanner;

public class ThrowsEx01 {

	public static void main(String[] args) {
		try {
		Scanner sc1=new Scanner(System.in);
		
		System.out.print("첫번째수는 : ");
		String one2=sc1.nextLine();
		int soo1=Integer.parseInt(one2);
		
		System.out.print("두번째수는 : ");
		String two2=sc1.nextLine();
		int soo2=Integer.parseInt(two2);
		
		int bada=kaja(soo1,soo2);
		System.out.println(bada);
		}catch(Exception e) {
			System.out.println("여기서 에러 처리한다. ");
		}
	}//main end
	
	//Throw 예문
	/*private static int kaja(int soo1, int soo2) {
		//soo1/soo2 할때 에러가 자주날 soo2(분모)에 에러 체크
		if(soo2==0) {
			System.out.println("0으로 나눌수 없다. ");
			throw new ArithmeticException();
		}
		else
			return soo1/soo2;
	}//kaja end
	*/
	
	//throws 예문
	private static int kaja(int soo1, int soo2) 
		throws ArithmeticException{
			return soo1/soo2;
		}//kaja end
	
}//class end
