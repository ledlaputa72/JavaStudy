package constarg;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import insa.Insa;


public class Constarg {
	
	//@Resource(name="insaBean") //�̸����� 
	@Autowired //type���� ���� 
	private Insa insa; //insaBean�̸��� �����Ǥ���. 

	public String kajaHello(String str1) {
		return insa.helloName(str1);
	}
}
