package insapkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Insa 클래스 위에 적어 놓는다ㅏ
@Component("insa10") // or @Component(value="insa10")
//==> <bean id="insa10" ... 
//"insa10"을 안적으면 자동으로 클래스명"Insa"를 "insa"로 바꿔서 이름을 자동 생성한다.  
//그러니까  <context:component-scan base-package="insapkg"/>이 
//Insa 클래스를 applicationContext에 bean으로 등록시켜 
// 이클래스가 spring bean이라고 알려준다. 

public class Insa {
	
	// property .. value = "홍길동"... 에 대한 annotation 
	/*<bean id="insabean" class="insapkg.Insa">
	<property name="name" value="홍길동">
	</bean>*/
	@Value("홍길동") //프로퍼티값 
	
	private String name; //setName("홍길동") or 생성자로 처리 
	
	//생성자
	public Insa(String name) { //생성자 오버로딩 
		this.name = name;
	}
	
	public Insa() { //디폴트 생성자 		
	}
	
	//setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//출력 내용 
	public String helloName(String str1) {
		return this.name + " 님\n" + str1;
	}
}
