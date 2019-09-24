package hello;

import org.springframework.context.support.GenericXmlApplicationContext;

import insa.Insa;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("<<<<<<<<<<안녕>>>>>>>>>>");
		String str1 = "오늘 날씨 어때요?";
		GenericXmlApplicationContext gxac1 = new GenericXmlApplicationContext("applicationContext1.xml");
		Insa insa1 = gxac1.getBean("insaBean", Insa.class);
			//xml에서 Insa클래스 객체가 만들어졌으므로 
			//Insa클래스의 insaGo()메소드 사용 가능 
		System.out.println(insa1.insaGo(str1)); //객체 메소드
		
		gxac1.close();
	}
}
