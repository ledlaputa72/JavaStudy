package constarg;

import org.springframework.stereotype.Component;

import insa.Insa;

public class Constarg {
	
	//@Resource(name="insaBean") //�̸����� 
	//@Autowired //type���� ���� 
	private Insa insa; //insaBean�̸��� ����ȴ�. 

	public Constarg(Insa insaBean) {
		// TODO Auto-generated constructor stub
		this.insa=insa;
	}
	
	public Constarg() {}
	

	public String kajaHello(String str1) {
		return insa.helloName(str1);
	}
}
