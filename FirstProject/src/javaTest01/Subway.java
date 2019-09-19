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
		System.out.println("지하철 " + lineNumber + "번의 승객은 "+passengerCount + "명이고, 수입은 "+money+"입니다. ");
	}
	
	
}
