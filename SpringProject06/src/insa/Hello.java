package insa;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("<<<<<<<<<<<<<<�ȳ�>>>>>>>>>>>>>>");
		String str1="Hello, Spring";
		
		GenericXmlApplicationContext gxac1=new GenericXmlApplicationContext("applicationContext1.xml");
		
		Insa insa1= gxac1.getBean("insaBean", Insa.class);
		
		System.out.println(insa1.helloName(str1)); //��ü �޼ҵ�
		
		gxac1.close();
		
	}

}
