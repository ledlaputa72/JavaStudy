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
		
		System.out.println("<<<<<<<<<<<<<<안녕>>>>>>>>>>>>>>");
		String str1="Hello, Spring";

		
		//.xml 설정 없이 ConfigurationBean이 .xmk역할 
		//이때 자바애노테이션에서는 
		//AnnotationConfigApplicationContext사용 
		ApplicationContext ac1=new AnnotationConfigApplicationContext("ConfigurationBean.class"); //.class주의 
		//이클립스에서 저장하는 순간에 컴파일 되어 
		//ConfigurationBean.java 가 ConfigurationBean.class가 된다. 

		Insa insa1= ac1.getBean("insaBean", Insa.class);
		System.out.println(insa1.helloName(str1)); //@Value("홍길동")
		
		Constarg con1 = ac1.getBean("constargBean", Constarg.class);
		System.out.println(con1.kajaHello(str1));
		
		((AbstractApplicationContext)ac1).close();
	
	}

}
