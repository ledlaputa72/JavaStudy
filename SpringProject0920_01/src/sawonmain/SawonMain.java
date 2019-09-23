package sawonmain;

import org.springframework.context.support.GenericXmlApplicationContext;

import sawonpkg.Sawon;
import hobby.Hobby;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext gxac1 = new GenericXmlApplicationContext("applicationContext2.xml"); 
		
		Sawon sawon1 = (Sawon)gxac1.getBean("sawonBean");
		System.out.println(sawon1.toString());
		
		Hobby con1=gxac1.getBean("hobbyBean",Hobby.class);
		con1.toString();
		
		con1.getSawon().hobbyString();
		
		gxac1.close();
		
	}

}
