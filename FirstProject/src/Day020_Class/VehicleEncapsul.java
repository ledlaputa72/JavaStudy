package Day020_Class;

class Car2 {
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
		
		System.out.println("���� ���� = "+redCar.getColor()+", ���� �� = "+redCar.getDoors()+", �������� = $"+redCar.getPrice());
		System.out.println("���� ���� = "+whiteCar.getColor()+", ���� �� = "+whiteCar.getDoors()+", �������� = $"+whiteCar.getPrice());
	}// main end

}
