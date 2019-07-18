package Day020_Class;

class Car2 {
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
	
};//Car Class end

public class VehicleEncapsul {

	public static void main(String[] args) {
		Car2 redCar=new Car2();
		
		redCar.setColor("Red"); 
		redCar.setDoors(4);
		redCar.setPrice(3000);;
		
		Car2 whiteCar=new Car2();
		whiteCar.setColor("white");
		whiteCar.setDoors(2);
		whiteCar.setPrice(20000);
		
		System.out.println("차량 색상 = "+redCar.getColor()+", 차량 문 = "+redCar.getDoors()+", 차량가격 = $"+redCar.getPrice());
		System.out.println("차량 색상 = "+whiteCar.getColor()+", 차량 문 = "+whiteCar.getDoors()+", 차량가격 = $"+whiteCar.getPrice());
	}// main end

}
