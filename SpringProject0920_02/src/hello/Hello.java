package hello;

import org.springframework.context.support.GenericXmlApplicationContext;

import constarg.Constarg;
import insapkg.Insa;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("<<<<<<<<<<<<<<�ȳ�>>>>>>>>>>>>>>");
		String str1="Hello, Spring";

		GenericXmlApplicationContext gxac1=new GenericXmlApplicationContext("applicationContext1.xml"); 

		Insa insa1= gxac1.getBean("insa10", Insa.class);
		System.out.println(insa1.helloName(str1)); //@Value("ȫ�浿")
		
		/*public String helloName(String str1) {
		 * --> �̰� ȣ��� @Value("ȫ�浿")�� ����� 
			return this.name + " ��\n" + str1;
		}*/
		
		gxac1.close();
		
	}

}
