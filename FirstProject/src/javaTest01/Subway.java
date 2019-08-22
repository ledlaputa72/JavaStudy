package javaTest01;

public class Subway {

	String lineNumber;
	int passengerCount;
	int money;
	
	public Subway(String lineNumber) {
		super();
		this.lineNumber = lineNumber;
	}
	
	public void takeSubway(int money) {
		this.money += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.println("����ö " + lineNumber + "���� �°��� "+passengerCount + "���̰�, ������ "+money+"�Դϴ�. ");
	}
	
	
}
