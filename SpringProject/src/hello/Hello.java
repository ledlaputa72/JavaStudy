package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bangka.Bangka1;
import bangka.Bangka2;

public class Hello {

	public static void main(String[] args) {
		
/*
		// spring - Dynamic Web 으로 작성
		// 스프링 자바이므로 run application 으로 실행

		Bangka1 b1 = new Bangka1(); // new
		
		b1.bangkabangka1("홍길동");
		
		Bangka2 b2 = new Bangka2(); // new
		
		b2.bangkabangka2("이도령");
*/
		
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("applicationContext1.xml"); //ctrl + shift + o
		// classpath 에서 xml 을 읽어와 bean 설정 메타 정보 등을 얻는다.
		// applicationcontext 인스턴스를 생성
		//그러니까 Bangka1 클래스에 대한 new가 여기서 만드는게 아니다. 
		/* Bangka1 b1= new Bangka1(); */
		
		Bangka1 b1 = (Bangka1) ac1.getBean("bangkaBean1"); //no new
		// bean 객체를 생성한 IoC 컨테이너로부터 bean 객체를 가져온다. (get 한다.)
		// DI (의존성 주입) 가 이루어진다.
		// 즉, 쉽게 말하면 new 를 xml 환경설정에서 만들고
		// 해당 객체를 갖고 와서 사용
		// 복잡한 수정이 필요시 xml 위주로 수정하면 된다.
		
		b1.bangkabangka1("홍길동");
		
		Bangka2 b2 = (Bangka2) ac1.getBean("bangkaBean2");
		
		b2.bangkabangka2("이도령");

	}

}
