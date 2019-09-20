package hello;


import org.springframework.context.support.GenericXmlApplicationContext;

import constarg.Constarg;
import insapkg.Insa;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("<<<<<<<<<<<<<<¾È³ç>>>>>>>>>>>>>>");
		String str1="Hello, Spring";

		GenericXmlApplicationContext gxac1=new GenericXmlApplicationContext("applicationContext1.xml"); 

		Insa insa1= gxac1.getBean("insaBean", Insa.class);
		System.out.println(insa1.helloName(str1)); //@Value("È«±æµ¿")
		
		Constarg con1 = gxac1.getBean("constargBean",Constarg.class);
		System.out.println(con1.kajaHello(str1));
				
		gxac1.close();
		
	}

}
