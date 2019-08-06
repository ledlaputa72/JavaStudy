package javaTest01;

class Birthday{
	int day;
	int month;
	int year;
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void printThis() {
		System.out.println(this);
	}
	
}

public class ClassTest02 {

	public static void main(String[] args) {
		
		Birthday dDay=new Birthday();
		dDay.setYear(2000);
		System.out.println(dDay);
		dDay.printThis();
		
	}

}
