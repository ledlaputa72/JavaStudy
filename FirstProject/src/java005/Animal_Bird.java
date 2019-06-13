package java005;

class Animal{
	public void soomshim() {
		System.out.println("SoomShim");
	}
}

class Bird extends Animal{
	public void singing() {
		System.out.println("Singing");
	}
}
public class Animal_Bird {
	
	public static void main(String[] args) {
		Animal a1=new Animal();
		a1.soomshim();
		
		Bird b1=new Bird();
		b1.soomshim();
		b1.singing();
	}

}
