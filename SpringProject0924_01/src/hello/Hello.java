package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helloProcess.HelloProcess;

public class Hello {

	public static void main(String[] args) {

		System.out.println("<< �ȳ� >>");
		
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("aopxml1.xml");
		
		HelloProcess hp1 = (HelloProcess) ac1.getBean("helloProcessBean");
		
		// �ֿ� ���� �޼ҵ� ����
		// ���� �ø��� �� (before) �� ���� ���� ����
		hp1.kajaDrive();
		hp1.kajaDrive1();
		hp1.kajaDrive();
		hp1.kajaDrive1();
		hp1.kajaDrive();
		hp1.kajaDrive1();
		
		((AbstractApplicationContext) ac1).close();

	}

}
