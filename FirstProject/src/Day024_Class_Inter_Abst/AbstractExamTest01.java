package Day024_Class_Inter_Abst;

abstract class Shape{

	public abstract void draw(); //�߻� �޼ҵ�
}

class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("(x,y)�߽����� r�������� ��");
	}
}

class Rect extends Shape{
	@Override
	public void draw() {
		System.out.println("(x,y)��ǥ���� width�� heigth�� �簢��");
	}
}

public class AbstractExamTest01 {

	public static void main(String[] args) {

		Shape s1=new Circle();
		s1.draw();
		
		Shape s2=new Rect();
		s2.draw();
	}

}
