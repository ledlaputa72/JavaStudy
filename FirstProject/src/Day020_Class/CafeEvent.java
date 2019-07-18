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
		Cafe cf1=new Cafe("�Ƹ޸�ī��","��",3000,"������");
		Cafe cf2=new Cafe("��","��",3500,"������");
		Cafe cf3=new Cafe("����������","��",2500,"ȫ����");
		Cafe cf4=new Cafe("�����ƶ�", "��", 4000, "������");
		Cafe cf5=new Cafe("������ġ��","��",4500, "�Ǵ���");
		Cafe event=new Cafe();
		
		System.out.println("       ## ��              �� ##       ");
		System.out.println("------------------------------");
		System.out.println("Ŀ���̸�"+"\t"+"Ŀ��ũ��"+"\t"+"Ŀ�ǰ���"+"\t"+"�����̸�");
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
		System.out.print("�̺�Ʈ�� Ŀ���� �̸� :");
		event.setName(sc1.next());
		System.out.print("�̺�Ʈ�� Ŀ���� ũ�� :");
		event.setSize(sc1.next());
		System.out.print("�̺�Ʈ�� Ŀ����  ������ :");
		event.setPrice(sc1.nextInt());
		System.out.print("�̺�Ʈ�� Ŀ���� ���� :");
		event.setStore(sc1.next());

		System.out.println("<�̴��� �̺�Ʈ> �α��α��α��α�~~~~");
		System.out.println(event.getName()+" "+event.getStore()+"���� "+"�̹� �޿� "+(int)(event.getPrice()*0.7)+"���� �Ǹ��մϴ�.");

	}

}
