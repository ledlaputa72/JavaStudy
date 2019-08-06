package bookstore;

import java.util.ArrayList;
import java.util.Scanner;

class Bookstore{
	
	private String book_name;
	private String book_genre;
	private int book_price;
	
	//1) getter setter
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_genre() {
		return book_genre;
	}
	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	
	//default ������
	public Bookstore() {
		super();
	}
	//������
	public Bookstore(String book_name, String book_genre, int book_price) {
		super();
		this.book_name = book_name;
		this.book_genre = book_genre;
		this.book_price = book_price;
	}

	//2) toString overriding
	@Override
	public String toString() {
		return "[å�̸�] "+this.book_name+"  [�帣] "+this.book_genre+"  [å����] "+this.book_price;
	}	
} //Bookstore class end



public class BookstoreClass {

	public static void main(String[] args) {
		//3)Bookstore ��ü b1
		Bookstore b1=new Bookstore();
		//setter �Է�
		b1.setBook_name("�ڹ��� ����-2nd");
		b1.setBook_genre("��ǻ��");
		b1.setBook_price(35000);

		System.out.println(b1);//b1 ���
		System.out.println("-----------------------------------");
		
		//4)Bookstore ��ü b2
		Bookstore b2=new Bookstore("���� ������ �㿡","�Ҽ�",10000);
		
		System.out.println(b2);//b2 ���
		System.out.println("-----------------------------------");
		
		//5)Collection-Generic ��� //////////////////////////////////////////
		ArrayList<Bookstore> arr=new ArrayList<Bookstore>();
		//��ü b1,b2 �߰� 
		arr.add(b1);
		arr.add(b2);
		//�߰� 5���� �׸� 
		arr.add(new Bookstore("������ ���� 3��","��Ÿ��",15000));
		arr.add(new Bookstore("�Ƹ��� Ŭ����","��ǻ��",30000));
		arr.add(new Bookstore("���ΰ� �ٴ�      ","�Ҽ�",12000));
		arr.add(new Bookstore("�ظ����� ��2�� ","��Ÿ��",15000));
		arr.add(new Bookstore("���� �������� ","����",10000));
		
		System.out.println("================================");
		System.out.println("      å ����           |   �帣      |   ����  ");
		System.out.println("--------------------------------");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getBook_name()+"\t"+arr.get(i).getBook_genre()+"\t"+arr.get(i).getBook_price());
		}
		System.out.println("================================");
		
		//6)Ű���� �˻����� ã�� �޼ҵ��  
		int sntA=serchArr(arr);
		
		
		//7)�˻��� �ѱǼ��� ��� 
		System.out.println("==================================");
		System.out.println("�˻��� å�� ���"+sntA+"�� �Դϴ�.");
		
	}//main end

	private static int serchArr(ArrayList<Bookstore> arr) {

		Scanner sc=new Scanner(System.in);
		System.out.println("å�� �帣�� �Է��ϼ���");
		String scGenre=sc.next();
		System.out.println("å�� ������ �Է��ϼ���");
		int scPrice=Integer.parseInt(sc.next());
		
		System.out.println("�˻��� �帣��? : "+scGenre);
		System.out.println("�˻��� ������? :"+scPrice);
		System.out.println("�˻��� ���");
		System.out.println("================================");
		int cnt=0;
		for (int i = 0; i < arr.size(); i++) {
			if(scGenre.equals(arr.get(i).getBook_genre())&&scPrice<=(arr.get(i).getBook_price())) {
				System.out.println(arr.get(i));
				cnt++;
			}
		}
		
		return cnt;
	}//serchArr end

}//main class end
