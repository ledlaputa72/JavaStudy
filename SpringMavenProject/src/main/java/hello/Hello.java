package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bangka.Bangka1;
import bangka.Bangka2;

public class Hello {

	public static void main(String[] args) {
		
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("applicationContext1.xml"); //ctrl + shift + o
		
		Bangka1 b1 = (Bangka1) ac1.getBean("bangkaBean1");
		b1.bangkabangka1("홍길동");
		System.out.println(b1); //toString()을 사용하면 확실해짐 
		
		/*Car c1 = new Car();
		Car c2 = new Car();*/
		Bangka1 b3 = (Bangka1) ac1.getBean("bangkaBean1"); 
		b1.bangkabangka1("성춘향");
		System.out.println(b3);
		// b1과 b3는 같은 객체 (single instance)
		//즉, 1<bean>태그에 1객체만 생성됨
		//b1, b3내용 동시 출력시 문제점 발생 
		// connection Pool
		
		Bangka2 b2 = (Bangka2) ac1.getBean("bangkaBean2"); 
		b1.bangkabangka1("이도령");
		System.out.println(b2); //b2와 b11은 prototype
		
		Bangka2 b11 = (Bangka2) ac1.getBean("bangkaBean2"); 
		b1.bangkabangka1("홍길순");
		System.out.println(b11); //b2와 b11은 prototype
		//scope가 prototype일때 자바 new와 같은 형태이다. 

	}

}
