package java001;

public class MethodTest { // class ����

		// �޼ҵ� ȣ�⹮
		public static void main(String[] args) {
		kaja(); // �޼ҵ� 1���� (�ǵ��� �ö� ��� �ڷ� �´�)
		kaja2(300); // �޼ҵ� 2����, ����,�μ�, argument�� ���ԵǸ� 2����, (�ǵ��� �ö� ��� �ڷ� �´�)
		//String bada=kaja3();// �޼ҵ� 3���� (�ǵ��� �ö� ����� ���ڸ��� ���ƿ´�)
		//System.out.println("����"+bada);
		System.out.println(kaja3()); //3������ ��� ��ȯ�� ���� ���� �� ����� 2������ �� �������� ���� �� �ִ�.
	    } // main��
		
		// �޼ҵ� 3���� - return�� �ִ�. 
		private static String kaja3() { // ���⼭ String�� ��ȯ���̶�� ��
			String moo="������";
			System.out.println("�ڹٿ� �츮�ݿ� ���Ͽ����Ѵٸ�");
			return "�ְ��~~"+moo; // ���� ������ ���� �Ѵ�. ��� ���� ������ �˾ƾ� �Ѵ�. 
		} // �޼ҵ� 3���� ��

		// �޼ҵ� 2���� - ����, �μ� ���� �ִ�. 
		private static void kaja2(int don) { //�Ű�����, parameter
			System.out.println(don+"���� �Ա��Ϸ� ����.");
		} // �޼ҵ� 2���� ��
		
		
	    // �޼ҵ�(�Լ�) ���ǹ� - �޼ҵ� 1����
		public static void kaja() {
		int y=2019;
		if (y%4==0 && y%100!=0 || y%400==0) //���� Ȯ��  
			System.out.println("����");
		else
		System.out.println("���");
		} // �޼ҵ� 3����

}// class ��
