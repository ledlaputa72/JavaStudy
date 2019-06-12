package java004;

class BBang2 { //정의 
	private String jong; //캡슐화,  private로 외부 클래스에서 접급이 불가능 한다. 
	private int ka; 
	// private 속성을 꺼내주고, 받게 하는 도우미(메소드)가 필요하다. public 
	
	//속성을 사용할 수 있게 도우미 메소드를 정의 한다. 
	public void setJong (String jong) { //값을 넣는 도우미 메소드
		this.jong = jong; // 객체.속성=값  
		// 앞에 jong은 위의 객체 속성, 뒤의 jong은 메소드의 인자, 앞에 this.을 붙여 구분해 준다. 
	}
	
	public String getJong () { // 값에서 받아오는 도우미 메소드
		return jong; //jong을 그냥써도 되고, this.jong을 써도 된다. 
	}
	
	public void setKa (int ka) { //값을 넣는 도우미 메소드
		this.ka = ka; 
	}
	
	public int getKa () { // 값에서 받아오는 도우미 메소드
		return this.ka;  //jong을 그냥써도 되고, this.jong을 써도 된다. 
	}
	
}

public class BreadEncapsul {
	public static void main(String[] args) {
		BBang2 b1=new BBang2(); // 생성
		// b1.jong="팥빵"; 이렇게 안된다.
		b1.setJong("슈크림빵"); //속성값을 넣는 setJong
		b1.setKa(2000);
				
		System.out.println(b1.getJong()); //속성값을 가져오는 getJong
		System.out.println(b1.getKa());
		
		BBang2 b2=new BBang2(); // 생성
		b2.setJong("슈크림빵"); //속성값을 넣는 setJong
		b2.setKa(2000);
		
		System.out.println(b2.getJong()); //속성값을 가져오는 getJong
		System.out.println(b2.getKa());
		
	}

}
