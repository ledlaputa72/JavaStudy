package constarg;

import insa.Insa;

public class Constarg {
	private Insa insa;

	public Constarg(Insa insa) {
		this.insa = insa;
	}
	
	public Constarg() { } 
	
	public String kajaHello(String str1) {
		return insa.helloName(str1);
		//insaBean°´Ã¼.helloName()
	}
}
