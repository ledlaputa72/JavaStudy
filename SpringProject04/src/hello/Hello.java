package hello;

import org.springframework.context.support.GenericXmlApplicationContext;

import insa.Insa;
import setter.Setter;


public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("<<<<<<<<<<<<¾È³ç>>>>>>>>>>>>");
		String str1 = "Hello, Spring ";
		
		GenericXmlApplicationContext gxac1 = new GenericXmlApplicationContext("applicationContext3.xml");
		
		Insa insa1 = gxac1.getBean("insaBean", Insa.class);
		System.out.println(insa1.helloName(str1));
		
		Setter setter1 = gxac1.getBean("setterBean", Setter.class);
		System.out.println(setter1.KajaHello(str1));
		
		gxac1.close();

	}

}
