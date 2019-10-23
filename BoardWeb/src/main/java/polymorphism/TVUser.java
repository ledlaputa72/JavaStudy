package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//1. Spring 컨테이너 구동 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.Spring 컨테이너로부터 필요한 객체를 요청 한다. 
		TV tv = (TV) factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}



/*BeanFactory factory = new BeanFactory();
TV tv = (TV) factory.getBean(args[0]);
tv.powerOn();
tv.volumeUp();
tv.volumeDown();
tv.powerOff();*/