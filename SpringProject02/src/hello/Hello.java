package hello;

import org.springframework.context.support.GenericXmlApplicationContext;

import insa.Insa;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("<<<<<<<<<<�ȳ�>>>>>>>>>>");
		String str1 = "���� ���� ���?";
		GenericXmlApplicationContext gxac1 = new GenericXmlApplicationContext("applicationContext1.xml");
		Insa insa1 = gxac1.getBean("insaBean", Insa.class);
			//xml���� InsaŬ���� ��ü�� ����������Ƿ� 
			//InsaŬ������ insaGo()�޼ҵ� ��� ���� 
		System.out.println(insa1.insaGo(str1)); //��ü �޼ҵ�
		
		gxac1.close();
	}
}
