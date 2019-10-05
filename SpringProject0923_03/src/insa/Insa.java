package insa;

public class Insa {

	//@Autowired @Value("홍길동") //필드 
	//@Qualifier("koobeok")
	private String name; //setName("홍길동") or 생성자로 처리 
	
	public Insa(String name) {
		this.name=name;
	}
	
	public Insa() {	}
	
	//출력 내용 
	public String helloName(String str1) {
		return this.name + " 님\n" + str1;
	}
}
