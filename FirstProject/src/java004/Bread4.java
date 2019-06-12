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

	//출력전문 메소드 -1 (일반적인 방법) 
	public void print1() { //이 방법은 종류와 가격(객체 속성)이 public일때 가능하다. 
//		System.out.println("빵이름은 "+jong+"이고, 가격은 "+ka+"입니다."); //jong or this.jong 모두 가능에러
//		System.out.println("빵이름은 "+b1.getJong+"이고, 가격은 "+b1.getKa+"입니다."); //에러
		System.out.println("빵 이름은 "+this.getJong()+"이고, 가격은 "+this.getKa()+"입니다."); 
		//this.getJong BBang4에 있는 getJong을 의미 
	}
	//출력전문 메소드 -2 (자주 사용하는 방법) 
	
} //BBang4 end

public class Bread4 {
	public static void main(String[] args) {
		BBang4 b1=new BBang4("소보로빵",3000); // 객체를 만들면서 초기치를 넣고 싶을때, 생성+초기치
//		System.out.println(b1.getJong()); 
//		System.out.println(b1.getKa());
		b1.print1(); //객체.메소드, 출력 메소드를 이용한 방법
		
		BBang4 b2=new BBang4(); //초기치 없이 생성만 넣는 경우  (디폴트 생성자를 안만들어 주고 있다. 위쪽 때문에)
	}
} // Bread4 end
