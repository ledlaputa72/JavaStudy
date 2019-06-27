package Java011_Test02;

import java.util.ArrayList;

class Store {
	private String name;
	private int price;
	private String type;
	private int amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Store() {
		super();
	}
	
	public Store(String name, int price, String type, int amount) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Store [name=" + name + ", price=" + price + ", type=" + type + ", amount=" + amount + "]";
	}
	
}

public class ExamTest03 {

	public static void main(String[] args) {

		Store arr=new Store();
		arr.setName("과자");
		arr.setType("밀가루");
		arr.setPrice(1500);
		arr.setAmount(10);
		
			System.out.println(arr);
			System.out.println("=================");
		
		ArrayList<Store> arr1=new ArrayList<Store>();	
		arr1.add(new Store("과자1",1500,"밀가루",10));
		arr1.add(new Store("과자2",1500,"밀가루",10));
		arr1.add(new Store("과자3",1500,"밀가루",10));
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
	}

}
