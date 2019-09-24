package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bangka.Bangka1;
import bangka.Bangka2;

public class Hello {

	public static void main(String[] args) {
		
/*
		// spring - Dynamic Web ���� �ۼ�
		// ������ �ڹ��̹Ƿ� run application ���� ����

		Bangka1 b1 = new Bangka1(); // new
		
		b1.bangkabangka1("ȫ�浿");
		
		Bangka2 b2 = new Bangka2(); // new
		
		b2.bangkabangka2("�̵���");
*/
		
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("applicationContext1.xml"); //ctrl + shift + o
		// classpath ���� xml �� �о�� bean ���� ��Ÿ ���� ���� ��´�.
		// applicationcontext �ν��Ͻ��� ����
		//�׷��ϱ� Bangka1 Ŭ������ ���� new�� ���⼭ ����°� �ƴϴ�. 
		/* Bangka1 b1= new Bangka1(); */
		
		Bangka1 b1 = (Bangka1) ac1.getBean("bangkaBean1"); //no new
		// bean ��ü�� ������ IoC �����̳ʷκ��� bean ��ü�� �����´�. (get �Ѵ�.)
		// DI (������ ����) �� �̷������.
		// ��, ���� ���ϸ� new �� xml ȯ�漳������ �����
		// �ش� ��ü�� ���� �ͼ� ���
		// ������ ������ �ʿ�� xml ���ַ� �����ϸ� �ȴ�.
		
		b1.bangkabangka1("ȫ�浿");
		
		Bangka2 b2 = (Bangka2) ac1.getBean("bangkaBean2");
		
		b2.bangkabangka2("�̵���");

	}

}
