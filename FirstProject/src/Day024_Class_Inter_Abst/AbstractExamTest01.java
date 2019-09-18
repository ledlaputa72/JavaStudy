package Day024_Class_Inter_Abst;

abstract class Shape{

	public abstract void draw(); //추상 메소드
}

class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("(x,y)중심으로 r반지름의 원");
	}
}

class Rect extends Shape{
	@Override
	public void draw() {
		System.out.println("(x,y)좌표에서 width와 heigth의 사각형");
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
