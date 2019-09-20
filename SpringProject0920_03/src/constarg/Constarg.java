package constarg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import insapkg.Insa;

@Component("constarg10")	 //

public class Constarg {
	
	@Value("insa10") //프로퍼티값
	
	private Insa insa;
	
	public Constarg(Insa insa) {
		this.insa = insa;
	}
	
	public Constarg() { }
	
	public String kajaHello(String str1) {
		return insa.helloName(str1);
	}
}
