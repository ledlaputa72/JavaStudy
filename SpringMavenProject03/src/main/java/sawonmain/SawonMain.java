package sawonmain;

import org.springframework.context.support.GenericXmlApplicationContext;

import sawonpkg.SawonVO;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericXmlApplicationContext ac1 = new GenericXmlApplicationContext("applicationContext2.xml"); 
		
		SawonVO b1 = (SawonVO) ac1.getBean("sawonBean1");
											//xml���� ���� bean ��ü
		
		/*b1.setId(100); //main���� setId�� �Է� 
			//SawonŬ������ setter�� �����ǰ�
			//�̹� bean ��ü�� �����ϸ鼭 p:name="�¸�"������ 
			//setName("�¸�")�� �����Ǹ鼭 name���� "�¸�"�� �� 
*/		
		System.out.println(b1.toString());
			//�̸� ����� ���� public String toString() { //��� ���� �޼ҵ�
			// return "����� id�� " + id + ", ����̸��� " + name + "�̶��~~";
			//������ ����� id�� name�� ��� 
		
		System.out.println(b1);
	}

}
