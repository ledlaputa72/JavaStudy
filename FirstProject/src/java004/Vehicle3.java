package java004;

class Car3 {
	private String color; // ���������� public Vehicle class���� ������ �����ϴ�. 
	private int doors;
	private int price;

	public void setColor(String color) {
		this.color=color;
	}
	public void setDoors(int doors) {
		this.doors=doors;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public String getColor() {
		return color;
	}
	public int getDoors() {
		return doors;
	}
	public int getPrice() {
		return price;
	}
	
	public Car3(String color, int doors, int price) {//������ �����ε�
		this.color=color;
		this.doors=doors;
		this.price=price;
	}
	
	public Car3() { // ������ �����ε� 
	}
	
};//Car Class end

public class Vehicle3 {

	public static void main(String[] args) {
		Car3 redCar=new Car3("Red",4,3000); // �޼ҵ� 2���� Ÿ�� ����
		Car3 whiteCar=new Car3(); // �޼ҵ� 1���� Ÿ�� ���� 
		
		System.out.println("���� ���� = "+redCar.getColor()+", ���� �� = "+redCar.getDoors()+", �������� = $"+redCar.getPrice());
		System.out.println("���� ���� = "+whiteCar.getColor()+", ���� �� = "+whiteCar.getDoors()+", �������� = $"+whiteCar.getPrice());
	}// main end

}
