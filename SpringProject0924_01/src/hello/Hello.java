package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helloProcess.HelloProcess;

public class Hello {

	public static void main(String[] args) {

		System.out.println("<< 안녕 >>");
		
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("aopxml1.xml");
		
		HelloProcess hp1 = (HelloProcess) ac1.getBean("helloProcessBean");
		
		// 주요 로직 메소드 실행
		// 가동 시마다 전 (before) 에 공통 로직 가동
		hp1.kajaDrive();
		hp1.kajaDrive1();
		hp1.kajaDrive();
		hp1.kajaDrive1();
		hp1.kajaDrive();
		hp1.kajaDrive1();
		
		((AbstractApplicationContext) ac1).close();

	}

}
