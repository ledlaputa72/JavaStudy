package Day021_Class2;

class Animal{
	String noon;
	
	public void soomshim() {
		System.out.println("숨쉰다");
	}
	
	public Animal() { //Animal 생성자1 (인자없는)
		System.out.println("난 동물이야!");
	}
	
	public Animal(int soo) { //Animal 생성자2 (인자있는)
		System.out.println("나는 눈이 "+soo+"개야.");
	}

}

class Bird extends Animal{
	int soo;
	
	public Bird(String noon, int soo) { //Bird 생성자, 상속받은 noon을 사용할수 있고, 자기만든 soo를 사용
		super(soo);//Animal 부모로 간다. 생성자 2를 찾아감 soo안의 2를 가지고 감 
		this.noon=noon;
		this.soo=soo;
		System.out.println("자녀가 객체에다 값 넣기 끝");
		//상속에서는 생성자 호출시 부모생성자를 먼저 수행하고 자녀생성자를 수행한다. 
	}
	
	public Bird() {
		
	}

	public void singing() {
		System.out.println("노래한다");
		System.out.println("난 새야");
	}
	
}
public class Animal_Bird {
	
	public static void main(String[] args) {
		Animal a1=new Animal();
		a1.soomshim();
		
		Bird b1=new Bird();
		b1.soomshim();
		b1.singing();
		Bird b2=new Bird("eyes",2);//자녀 생성자만 호출
	}

}
