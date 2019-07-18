package Day020_Class1;

class Car {
	public String color; // 접근지정자 public Vehicle class에서 접근이 가능하다. 
	public int doors;
	public int price;
};//Car Class end

public class Vehicle {

	public static void main(String[] args) {
		Car redCar=new Car();
		redCar.color="Red"; //Car class의 public으로 된 color,doors,price에 사용이 가능
		redCar.doors=4;
		redCar.price=30000;
		
		Car whiteCar=new Car();
		whiteCar.color="White";
		whiteCar.doors=2;
		whiteCar.price=20000;
		
		System.out.println("차량 색상 = "+redCar.color+", 차량 문 = "+redCar.doors+", 차량가격 = $"+redCar.price);
		System.out.println("차량 색상 = "+whiteCar.color+", 차량 문 = "+whiteCar.doors+", 차량가격 = $"+whiteCar.price);
	}// main end

}//class end
