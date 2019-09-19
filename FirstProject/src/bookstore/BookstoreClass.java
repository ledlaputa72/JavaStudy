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
	
	//default 생성자
	public Bookstore() {
		super();
	}
	//생성자
	public Bookstore(String book_name, String book_genre, int book_price) {
		super();
		this.book_name = book_name;
		this.book_genre = book_genre;
		this.book_price = book_price;
	}

	//2) toString overriding
	@Override
	public String toString() {
		return "[책이름] "+this.book_name+"  [장르] "+this.book_genre+"  [책가격] "+this.book_price;
	}	
} //Bookstore class end



public class BookstoreClass {

	public static void main(String[] args) {
		//3)Bookstore 객체 b1
		Bookstore b1=new Bookstore();
		//setter 입력
		b1.setBook_name("자바의 정석-2nd");
		b1.setBook_genre("컴퓨터");
		b1.setBook_price(35000);

		System.out.println(b1);//b1 출력
		System.out.println("-----------------------------------");
		
		//4)Bookstore 객체 b2
		Bookstore b2=new Bookstore("별이 빛나는 밤에","소설",10000);
		
		System.out.println(b2);//b2 출력
		System.out.println("-----------------------------------");
		
		//5)Collection-Generic 사용 //////////////////////////////////////////
		ArrayList<Bookstore> arr=new ArrayList<Bookstore>();
		//객체 b1,b2 추가 
		arr.add(b1);
		arr.add(b2);
		//추가 5개의 항목 
		arr.add(new Bookstore("반지의 제왕 3편","판타지",15000));
		arr.add(new Bookstore("아마존 클라우드","컴퓨터",30000));
		arr.add(new Bookstore("노인과 바다      ","소설",12000));
		arr.add(new Bookstore("해리포터 제2편 ","판타지",15000));
		arr.add(new Bookstore("월간 비디오게임 ","잡지",10000));
		
		System.out.println("================================");
		System.out.println("      책 제목           |   장르      |   가격  ");
		System.out.println("--------------------------------");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getBook_name()+"\t"+arr.get(i).getBook_genre()+"\t"+arr.get(i).getBook_price());
		}
		System.out.println("================================");
		
		//6)키보드 검색으로 찾기 메소드로  
		int sntA=serchArr(arr);
		
		
		//7)검색된 총권수를 계산 
		System.out.println("==================================");
		System.out.println("검색된 책은 모두"+sntA+"권 입니다.");
		
	}//main end

	private static int serchArr(ArrayList<Bookstore> arr) {

		Scanner sc=new Scanner(System.in);
		System.out.println("책의 장르를 입력하세요");
		String scGenre=sc.next();
		System.out.println("책의 가격을 입력하세요");
		int scPrice=Integer.parseInt(sc.next());
		
		System.out.println("검색할 장르는? : "+scGenre);
		System.out.println("검색할 가격은? :"+scPrice);
		System.out.println("검색된 결과");
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
