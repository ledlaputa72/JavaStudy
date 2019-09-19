package sawonmain;

import org.springframework.context.support.GenericXmlApplicationContext;

import sawonpkg.SawonVO;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericXmlApplicationContext ac1 = new GenericXmlApplicationContext("applicationContext2.xml"); 
		
		SawonVO b1 = (SawonVO) ac1.getBean("sawonBean1");
											//xml에서 만든 bean 객체
		
		/*b1.setId(100); //main에서 setId로 입력 
			//Sawon클래스의 setter가 가동되고
			//이미 bean 객체를 생성하면서 p:name="태리"떄문에 
			//setName("태리")가 가동되면서 name에는 "태리"가 들어감 
*/		
		System.out.println(b1.toString());
			//미리 만들어 놓은 public String toString() { //출력 전문 메소드
			// return "사원의 id는 " + id + ", 사원이름은 " + name + "이라는~~";
			//때문에 결과로 id와 name이 출력 
		
		System.out.println(b1);
	}

}
