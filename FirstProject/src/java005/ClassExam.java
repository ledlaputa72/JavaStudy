package java005;

class AA{
	public void car() {
		System.out.println("Ŭ���� AA Car");
	}
}

class BB extends AA{
	public void car() { //AA�� car()�� ��� +a
		System.out.println("Ŭ���� BB Car");
	}
	
}

class CC extends BB{
	public void car() { //BB�� car()�� ��� +a
		System.out.println("Ŭ���� CC Car");
	}
}

public class ClassExam {

	public static void main(String[] args) {
		
		AA a1=new AA(); //AA�� ��ü a1
		BB b1=new BB(); //BB�� ��ü b1
		CC c1=new CC(); //CC�� ��ü c1
		//���
		a1.car(); //AA car���
		b1.car(); //BB car���
		c1.car(); //CC car���
		
		//-------------------
		AA a2=b1; //AA a2=new BB();
		BB b2=c1; //BB b2=new CC()
		//���
		a2.car(); //BB car���
		b2.car(); //CC car���
		
		//--------------------
		BB b3=(BB)a2; //BB b3=new BB(), a2=new BB()�̹Ƿ�
		CC c3=(CC)b2; //CC c3=new CC(), b2=new CCC()�̹Ƿ�
		//���
		b3.car(); //BB car���
		c3.car(); //AA car���
		
	}

}
