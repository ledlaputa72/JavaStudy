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

		Insa insa1= gxac1.getBean("insa10", Insa.class);
		System.out.println(insa1.helloName(str1)); //@Value("È«±æµ¿")
		
		/*public String helloName(String str1) {
		 * --> ÀÌ°Í È£Ãâ½Ã @Value("È«±æµ¿")°¡ Àû¿ëµÊ 
			return this.name + " ´Ô\n" + str1;
		}*/
		
		gxac1.close();
		
	}

}
