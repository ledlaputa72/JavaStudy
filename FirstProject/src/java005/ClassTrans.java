//��ü�� ����ȯ
package java005;

class Parent{
	public void car() { //car1
		System.out.println("���� �θ�-����̺갡��.");
	}
}

class Child extends Parent{
	public void car() { //car2, car1�� ��ӹ޾� ������ �� car()
		System.out.println("���� �ڳ�-���డ��.");
	}
}

public class ClassTrans {

	public static void main(String[] args) {
		
		Parent p1=new Parent(); //�θ� ��ü
		Child c1=new Child(); //�ڽ� ��ü
		p1.car();
		c1.car(); //car2
		//---------------------------------------
		//Parent p2=c1; // ��밡�� 
		Parent p2=new Child(); //Parent p2=c1;�� ������ ����. ��밡�� 
		
		//Child c2=p1; //����ȯ�� �ȵȴ�. 
		//Child c2=new Parent(); //Child c2=p1;�� ������ ����. ���Ұ�
		
		//�Ʒ� ���� ����
		Child c3=(Child)p2; // Child c3=new Child();
		//�Ʒ� ���� ����, Compile ok, Run err (�ڻ��� Ʋ���� ����)
		//Child c4=(Child)p1; //�������� ������ �����̴�. 
	}

}
