package java007_Test_SMarket;

import java.util.*;

//SMarket 클래스 
class SMarket{
	private String name; //상품 명
	private int price; //상품 가격
	private String counter; //매대 위치 
	
	//default 생성자 ////////////////////////////////
	public SMarket() { 
		super();
	}
	
	//생성자////////////////////////////////////////
	public SMarket(String name, int price,  String counter) {
		super();
		this.name = name;
		this.price = price;
		this.counter = counter;
	}
	
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

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	//출력
	@Override
	public String toString() {
		return "SMarket [name=" + name + ", price=" + price + ", counter=" + counter + "]";
	}
	
}// SMarket end


public class Main {

	public static void main(String[] args) {
		//do while Menu & switch
		//번호 선택 
		Scanner sc=new Scanner(System.in);
		
		//상품의 입력을 위한 컬랙션 리스트 
		ArrayList<SMarket> arr1=new ArrayList<SMarket>(); //
		
		 arr1.add(new SMarket("서울우유",2500,"A"));
         arr1.add(new SMarket("액티비아",3000,"A"));
         arr1.add(new SMarket("이오",2000,"A"));
         arr1.add(new SMarket("매일우유",2300,"A"));
         arr1.add(new SMarket("남양우유",2300,"A"));
         arr1.add(new SMarket("서울치즈",4000,"B"));
         arr1.add(new SMarket("코카콜라",1500,"C"));
         arr1.add(new SMarket("스프라이트",1400,"C"));
         arr1.add(new SMarket("썬키스트",4500,"D"));
        
         for (int i = 0; i < arr1.size(); i++) {
             System.out.println(arr1.get(i));
        }
		
		//메뉴 프로그램
		int selectMenu;
		do {
			System.out.println("==== SMarket 관리 프로그램 메뉴 ====");
			System.out.println("1) 상품 입력");
			System.out.println("2) 상품 수정");
			System.out.println("3) 상품 검색");
			System.out.println("4) 상품 삭제");
			System.out.println("5) 종료");
			System.out.println("선택하세요 (1-5)");
			
			//번호를 입력 받는다. 
			selectMenu=sc.nextInt();
			
			switch (selectMenu) {
			case 1:
				kajaCreate(arr1);
				break;
			case 2:
				kajaUpdate(arr1);
				break;
			case 3:
				kajaSearch(arr1);
				break;
			case 4:
				kajaDelete(arr1);
				break;
			case 5:
				
				break;
			default:
				break;
			}
		} while (selectMenu!=1 && selectMenu!=2 && selectMenu!=3 && selectMenu!=4&& selectMenu!=5);
		
		//4) 종료 

	} //main end
	
	//1) 상품 입력 메소드///////////////////////////////////////
	private static void kajaCreate(ArrayList<SMarket> arr1) {
		System.out.println("상품 입력");
		
		System.out.println("-----------상품을 입력하세요 -------------");
		

	}

	//2) 상품 수정 메소드/////////////////////////////////////////
	private static void kajaUpdate(ArrayList<SMarket> arr1) {
		System.out.println("상품 수정");
		
		System.out.println("-----------수정을 입력하세요 -------------");
		
	}

	//3) 상품 검색 메소드////////////////////////////////////////
	private static void kajaSearch(ArrayList<SMarket> arr1) {
		System.out.println("--------------상품 검색----------------");
		System.out.println("검색할 상품명을 입력하세요 ");
		Scanner sc=new Scanner(System.in);
		
		//검색찾기 
		for (int i = 0; i < arr1.size(); i++) {
			if (arr1.get(i).getName()==sc.next()) { //입력한 단어를 찾아서 같으면 출력
				System.out.println(arr1.get(i));
			}
		}
		
		System.out.println("검색을 마칩니다. ");
		
	}
	//4) 상품 삭제 메소드//////////////////////////////////////////////
	private static void kajaDelete(ArrayList<SMarket> arr1) {
		System.out.println("상품 삭제");
		
	}

}//class end
