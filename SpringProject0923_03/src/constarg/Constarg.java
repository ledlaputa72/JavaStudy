package constarg;

import org.springframework.stereotype.Component;

import insa.Insa;

public class Constarg {
	
	//@Resource(name="insaBean") //이름으로 
	//@Autowired //type으로 구분 
	private Insa insa; //insaBean이름이 적용된다. 

	public Constarg(Insa insaBean) {
		// TODO Auto-generated constructor stub
		this.insa=insa;
	}
	
	public Constarg() {}
	

	public String kajaHello(String str1) {
		return insa.helloName(str1);
	}
}
