package Day020_Class1;

class BBang { //���� : ������ Ŭ���� (���赵:�޸𸮿� ��������� �ʾҴ�.)
	public String jong; //���� ���� (�Ӽ�,�ʵ�)
	public int ka; //���� ���� (�Ӽ�,�ʵ�)
	
}
public class Bread {
	public static void main(String[] args) {
		BBang b1=new BBang(); //����1, b1�̶�� �̸�����  BBang��ü�� ã�ư� �� �ְ� �Ѵ�. 
		b1.jong="�ϻ�"; //��ü.�Ӽ�=��
		b1.ka=1200;
		
		BBang b2=new BBang(); //����2, b2��� ���ο� ��ü�� ���ܳ� 
		b2.jong="���ڻ�";
		b2.ka=3000;
		
		System.out.println(b1.jong+"\t"+b1.ka); //b1��ü.�Ӽ�
		System.out.println(b2.jong+"\t"+b2.ka); //b2��ü.�Ӽ�
	}

}
