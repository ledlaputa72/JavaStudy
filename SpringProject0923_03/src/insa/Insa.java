package insa;

public class Insa {

	//@Autowired @Value("ȫ�浿") //�ʵ� 
	//@Qualifier("koobeok")
	private String name; //setName("ȫ�浿") or �����ڷ� ó�� 
	
	public Insa(String name) {
		this.name=name;
	}
	
	public Insa() {	}
	
	//��� ���� 
	public String helloName(String str1) {
		return this.name + " ��\n" + str1;
	}
}
