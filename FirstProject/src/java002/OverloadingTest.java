package java002;

public class OverloadingTest {

	public static void main(String[] args) { //main method (����)
		kaja();
//		kaja2(300,200,500); //������ ���� �߻�
		kaja(300,200,500); // �Լ� �̸��� kaja�� �����ϰ� ��� , �޼ҵ�(�Լ�) �ߺ� : method overloading
		kaja(32.6, 78.7, 8); // �Լ� �̸��� kaja�� �����ϰ�, ������ ���� 3���� �����ϳ�, Ÿ���� Ʋ����. 
	}// main-end

	private static void kaja() { //kaja method (��) - 1����
		System.out.println("���õ� ����");
	}

//	private static void kaja2(int i, int j, int k) { // kaja2 method - 2����
	private static void kaja(int i, int j, int k) { // kaja�� �̸��� ������ ���ڰ� 3���� Ʋ��
		System.out.println(i+j+k);
	}

	private static void kaja(double d, double e, int k) { //�̸��� ���ڰ� �����ϳ� Ÿ���� Ʋ����.  
		System.out.println(d+e+k);
	}

}// class-end
