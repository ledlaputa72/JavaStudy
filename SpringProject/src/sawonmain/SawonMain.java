package sawonmain;

import org.springframework.context.support.GenericXmlApplicationContext;

import sawonpkg.SawonVO;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericXmlApplicationContext ac1 = new GenericXmlApplicationContext("applicationContext3.xml"); 
		
		SawonVO b1 = (SawonVO) ac1.getBean("sawonBean1");
		b1.setId(3);
		b1.setName("ÅÂ¸®");
		
		System.out.println(b1.toString());
		System.out.println(b1);
	}

}
