package javaTest01;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	
	public Bus(int busNumber) {
		super();
		this.busNumber = busNumber;
	}
	
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}

	public void showInfo() {
		System.out.println("���� " + busNumber + "���� �°��� "+passengerCount + "���̰�, ������ "+money+"�Դϴ�. ");
	}
	
}
