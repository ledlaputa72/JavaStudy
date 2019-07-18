package Day020_Class;

import java.util.Scanner;

class Cafe {
	private String name;
	private String size;
	private int price;
	private String store;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	} 
	
	public Cafe(String name, String size, int price, String store) {
		this.name=name;
		this.size=size;
		this.price=price;
		this.store=store;
	}
	
	public Cafe() {
		
	}
	
	public void print1() {
		System.out.println(this.getName()+"\t"+this.getSize()+"\t"+this.getPrice()+"\t"+this.getStore());
	}
}

public class CafeEvent {

	public static void main(String[] args) {
		Cafe cf1=new Cafe("아메리카노","중",3000,"종로점");
		Cafe cf2=new Cafe("라떼","대",3500,"강남점");
		Cafe cf3=new Cafe("에스프레소","소",2500,"홍대점");
		Cafe cf4=new Cafe("마끼아또", "대", 4000, "교대점");
		Cafe cf5=new Cafe("프라프치노","대",4500, "건대점");
		Cafe event=new Cafe();
		
		System.out.println("       ## 메              뉴 ##       ");
		System.out.println("------------------------------");
		System.out.println("커피이름"+"\t"+"커피크기"+"\t"+"커피가격"+"\t"+"매장이름");
		System.out.println("------------------------------");
		cf1.print1();
		cf2.print1();
		cf3.print1();
		cf4.print1();
		cf5.print1();
//		System.out.println(cf1.getName()+"\t"+cf1.getSize()+"\t"+cf1.getPrice()+"\t"+cf1.getStore());
//		System.out.println(cf2.getName()+"\t"+cf2.getSize()+"\t"+cf2.getPrice()+"\t"+cf2.getStore());
//		System.out.println(cf3.getName()+"\t"+cf3.getSize()+"\t"+cf3.getPrice()+"\t"+cf3.getStore());
//		System.out.println(cf4.getName()+"\t"+cf4.getSize()+"\t"+cf4.getPrice()+"\t"+cf4.getStore());
//		System.out.println(cf5.getName()+"\t"+cf5.getSize()+"\t"+cf5.getPrice()+"\t"+cf5.getStore());
		System.out.println("------------------------------");
		
		Scanner sc1=new Scanner(System.in);
		System.out.print("이벤트할 커피의 이름 :");
		event.setName(sc1.next());
		System.out.print("이벤트할 커피의 크기 :");
		event.setSize(sc1.next());
		System.out.print("이벤트할 커피의  원가격 :");
		event.setPrice(sc1.nextInt());
		System.out.print("이벤트할 커피의 매장 :");
		event.setStore(sc1.next());

		System.out.println("<이달의 이벤트> 두구두구두구두구~~~~");
		System.out.println(event.getName()+" "+event.getStore()+"에서 "+"이번 달에 "+(int)(event.getPrice()*0.7)+"원에 판매합니다.");

	}

}
