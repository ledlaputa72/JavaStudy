package study01;

public class TypeConver {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(n);
		double dNum = n;
		System.out.println(dNum);

		int iNum = 1000;
		byte bNum = (byte)iNum;
		System.out.println(iNum);
		System.out.println(bNum);
		
		double dNum1 = 1.2;
		float fNum2 = 0.9f;
		
		int iNum3 = (int)dNum1 + (int)fNum2;
		int iNum4 = (int)(dNum1 + fNum2);
		System.out.println(iNum3);
		System.out.println(iNum4);

	}

}
