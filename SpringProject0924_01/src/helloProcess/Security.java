package helloProcess;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //여기가 xml의 <aop:aspect>부분 즉, AspectJ를 보라는 
public class Security {
	
	//나  xml의 pointcut 부분 // 적용할것은 kajaDrive()
	@Pointcut("execution(* helloProcess..*())") 
	//helloProcess 클래스 밑에 모든 메소드(인자가 없는)에 적용 == kajaDrive()
	//스프링은 Pointcut 적용시 메소드 only
	
	private void mukja() {
		//아무 메소드를 만듬 
		//어떻게를 위해 , 그리고 구조를 위해 mukja() 이것 사용함 
		//에노테이션은 문법적으로 아무 메소드 위에 위치해야 하므로 빈 메소드 만들어 놓음 
	}
	
	//그런다음 mukja()에 대해 한번 써보자 
	//before  즉, kajaDrive() 가동전에 goSecurity() 수행 한다는
//	@Before("mukja()") //공통이 먼저 나온다. 
	@After("mukja()") //공통이 나중에 나온다. 
	public void goSecurity() {
		System.out.println("공통 : 여기는 보안 처리 중~");
	}
	//주요메소드에 before를 적용, 공통로직은 goSecurity()

}
