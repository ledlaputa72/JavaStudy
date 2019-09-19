package Day020_Class1;

class BBang { //정의 : 빵가게 클래스 (설계도:메모리에 만들어지지 않았다.)
	public String jong; //빵의 종류 (속성,필드)
	public int ka; //빵의 가격 (속성,필드)
	
}
public class Bread {
	public static void main(String[] args) {
		BBang b1=new BBang(); //생성1, b1이라는 이름으로  BBang객체를 찾아갈 수 있게 한다. 
		b1.jong="팥빵"; //객체.속성=값
		b1.ka=1200;
		
		BBang b2=new BBang(); //생성2, b2라는 새로운 객체가 생겨남 
		b2.jong="초코빵";
		b2.ka=3000;
		
		System.out.println(b1.jong+"\t"+b1.ka); //b1객체.속성
		System.out.println(b2.jong+"\t"+b2.ka); //b2객체.속성
	}

}
