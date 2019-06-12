package java004;

class BBang4 { 
	private String jong; // 객체 속성 
	private int ka;
	
	public BBang4(String jong, int ka) { // 생성자 오버로딩
		this.jong=jong;
		this.ka=ka;
	}
	
	public BBang4() { // 생성자 오버로딩 
	}

	public String getJong() {
		return jong;
	}
	public void setJong(String jong) {
		this.jong = jong;
	}
	public int getKa() {
		return ka;
	}
	public void setKa(int ka) {
		this.ka = ka;
	} 

	// 생성자(construct)
//	public BBang4(String jong, int ka) { //메소드같이 생겼으며, void/return이 없다. public으로 시작. 
//		this.jong=jong;
//		this.ka=ka;
//	}
	
}
public class Bread4 {
	public static void main(String[] args) {
		BBang4 b1=new BBang4("소보로빵",3000); // 객체를 만들면서 초기치를 넣고 싶을때, 생성+초기치
		
		System.out.println(b1.getJong()); 
		System.out.println(b1.getKa());
		
		BBang4 b2=new BBang4(); //초기치 없이 생성만 넣는 경우  (디폴트 생성자를 안만들어 주고 있다. 위쪽 때문에)
	}
}
