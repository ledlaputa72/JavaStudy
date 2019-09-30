package configurationbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import constarg.Constarg;
import insa.Insa;

//기존 annotation은 다 주석을 달고 시작 
@Configuration // 환경설정 파일 
public class ConfigurationBean {

	//applicarionContext1.xml --> Configurarion.java 
	//src폴더 안에 패키지안에 .java만들면 됨 
	//여기에 bean태스가 나오는 위치 @Bean으로 시작 
	@Bean //이것 자체는 insaBean() 메소드 
	public Insa insaBean() { //이름이 id개념=[객체명]
							//이것은 호출에 대한 메소드정의문 역할 
		return new Insa("홍길동"); //객체 만들어 리턴 
	} //new Insa("홍길동")객체가 bean 객체 
	
	public Constarg constargBean() { //id = bean객체 개념 
		return new Constarg(insaBean()); //insaBean()은 메소드 호출문 
		
	}
}

