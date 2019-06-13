package java005;

class Animal{
	String noon;
	public Animal() { //Animal 생성자1
		System.out.println("난 동물이야!");
	}
	
	public Animal(int soo) { //Animal 생성자2
		System.out.println("나는 눈이 "+soo+"개야.");
	}

	public void soomshim() {
		System.out.println("SoomShim");
	}
}

class Bird extends Animal{
	int soo;
	
	public Bird(String noon, int soo) { //Bird 생성자
		super(soo);//Animal 생성자 2를 찾아감 
		this.noon=noon;
		this.soo=soo;
		System.out.println("자녀가 객체에다 값 넣기 끝");
	}
	
	public Bird() {
		
	}

	public void singing() {
		System.out.println("Singing");
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
		Bird b2=new Bird("eyes",2);
	}

}
