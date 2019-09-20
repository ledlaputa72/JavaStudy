package constarg;


import org.springframework.beans.factory.annotation.Autowired;

import insapkg.Insa;


public class Constarg {
	
	@Autowired
	private Insa insa;
	

	public String kajaHello(String str1) {
		return insa.helloName(str1);
	}
}
