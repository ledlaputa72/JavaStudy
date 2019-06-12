package java004;

class Car3 {
	private String color; // 접근지정자 public Vehicle class에서 접근이 가능하다. 
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
	
	public Car3(String color, int doors, int price) {//생성자
		this.color=color;
		this.doors=doors;
		this.price=price;
	}
	
};//Car Class end

public class Vehicle3 {

	public static void main(String[] args) {
		Car3 redCar=new Car3("Red",4,3000);
		Car3 whiteCar=new Car3("white",2,2000);
		
		System.out.println("차량 색상 = "+redCar.getColor()+", 차량 문 = "+redCar.getDoors()+", 차량가격 = $"+redCar.getPrice());
		System.out.println("차량 색상 = "+whiteCar.getColor()+", 차량 문 = "+whiteCar.getDoors()+", 차량가격 = $"+whiteCar.getPrice());
	}// main end

}
