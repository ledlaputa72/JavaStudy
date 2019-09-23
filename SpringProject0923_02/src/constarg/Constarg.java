package constarg;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import insa.Insa;


public class Constarg {
	
	//@Resource(name="insaBean") //이름으로 
	@Autowired //type으로 구분 
	private Insa insa; //insaBean이름이 적용디ㅗㄴ다. 

	public String kajaHello(String str1) {
		return insa.helloName(str1);
	}
}
