package hello;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import constarg.Constarg;
import insa.Insa;
import configurationbean.*;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("<<<<<<<<<<<<<<�ȳ�>>>>>>>>>>>>>>");
		String str1="Hello, Spring";

		
		//.xml ���� ���� ConfigurationBean�� .xmk���� 
		//�̶� �ڹپֳ����̼ǿ����� 
		//AnnotationConfigApplicationContext��� 
		ApplicationContext ac1=new AnnotationConfigApplicationContext("ConfigurationBean.class"); //.class���� 
		//��Ŭ�������� �����ϴ� ������ ������ �Ǿ� 
		//ConfigurationBean.java �� ConfigurationBean.class�� �ȴ�. 

		Insa insa1= ac1.getBean("insaBean", Insa.class);
		System.out.println(insa1.helloName(str1)); //@Value("ȫ�浿")
		
		Constarg con1 = ac1.getBean("constargBean", Constarg.class);
		System.out.println(con1.kajaHello(str1));
		
		((AbstractApplicationContext)ac1).close();
	
	}

}
