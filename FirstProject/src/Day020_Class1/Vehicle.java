package Day020_Class1;

class Car {
	public String color; // ���������� public Vehicle class���� ������ �����ϴ�. 
	public int doors;
	public int price;
};//Car Class end

public class Vehicle {

	public static void main(String[] args) {
		Car redCar=new Car();
		redCar.color="Red"; //Car class�� public���� �� color,doors,price�� ����� ����
		redCar.doors=4;
		redCar.price=30000;
		
		Car whiteCar=new Car();
		whiteCar.color="White";
		whiteCar.doors=2;
		whiteCar.price=20000;
		
		System.out.println("���� ���� = "+redCar.color+", ���� �� = "+redCar.doors+", �������� = $"+redCar.price);
		System.out.println("���� ���� = "+whiteCar.color+", ���� �� = "+whiteCar.doors+", �������� = $"+whiteCar.price);
	}// main end

}//class end
