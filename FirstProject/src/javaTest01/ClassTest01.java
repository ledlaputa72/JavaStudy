package javaTest01;

class Person{
	String name;
	float height;
	float weight;
	
	public Person(String pname) {
		name=pname;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, float height, float weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	
}


public class ClassTest01 {

	public static void main(String[] args) {

		Person personLee=new Person();
	}

}
