package java006_Class2;

abstract class Kwail{ //�߻� Ŭ���� 
	public void good()
	{
		System.out.println("������ ����");
	}
	public abstract void mukja(); //�߻� �޼ҵ�
	//����X, ����O, ������ �ڳ��ʿ��� �Ѵ�. 
}

class Sakwa extends Kwail{
	@Override
	public void mukja() {
		System.out.println("����� �簢�簢 ����"); //���ڿ� ���� ������ ����� �Ѵ�. 
	}
}

class Bae extends Kwail{
	@Override
	public void mukja() {
		System.out.println("�踦 �ƻ�ƻ� ����");
	}
}

class Kam extends Kwail{
	@Override
	public void mukja() {
		System.out.println("���� �������� ����");
	}
}

public class ClassStudy201 {

	public static void main(String[] args) {
		
		Kwail k1=new Sakwa(); //��ü�� ����ȯ
		k1.mukja();
		
		Kwail k2=new Bae(); //k1,k2�� �ڳ�(���,��)�� ����Ű�� �ִ�. 
		k2.mukja();
		
		Kwail k3=new Kam(); //K3�� �ڳ�(��)�� ����Ű�� �ִ�.  
		k3.mukja();

	}

}
