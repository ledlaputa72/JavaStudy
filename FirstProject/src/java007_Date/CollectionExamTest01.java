package java007_Date;

import java.util.*;

//SMarket1 클래스////////////////////////////////////////////////////// 
class SMarket1{ 
	private String sangpum;
	private int price;
	private String wichi;
	
	//default 생성자////////////////////////////////////////////////////
	public SMarket1() {
		
	}
	
	//생성자//////////////////////////////////////////////////////////
	public SMarket1(String sangpum, int price, String wichi) {
		super();
		this.sangpum = sangpum;
		this.price = price;
		this.wichi = wichi;
	}
	
	//getter setter//////////////////////////////////////////////////
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWichi() {
		return wichi;
	}
	public void setWichi(String wichi) {
		this.wichi = wichi;
	}
	
	//toString 출력 메소드///////////////////////////////////////////////
	public String toString() {
		return "상품이름은 "+sangpum+"이고, 가격은 "+price+"이고, 상품의 매대 위치는 "+wichi+"입니다.";
	}
	
} //SMarket class end


public class CollectionExamTest01 {

	public static void main(String[] args) {

		//ArrayList가 먼저 있어야 한다./////////////////////////////////////
		ArrayList<SMarket1> arr1=new ArrayList<SMarket1>();
		
		//.add를 통해 값을 입력 ////////////////////////////////////////////
		arr1.add(new SMarket1("요쿠르트",2000,"A")); //집어 넣을때 .add
		arr1.add(new SMarket1("서울우유",2500,"A"));
		arr1.add(new SMarket1("액티비아",3500,"A"));
		arr1.add(new SMarket1("이오",2000,"A"));
		arr1.add(new SMarket1("매일우유",2300,"A"));
		arr1.add(new SMarket1("남양우유",2300,"A"));
		arr1.add(new SMarket1("서울치즈",4000,"B"));
		arr1.add(new SMarket1("코카콜라",1500,"C"));
		arr1.add(new SMarket1("스프라이트",1400,"C"));
		arr1.add(new SMarket1("썬키스트",4500,"D"));
		
		//동록된 제품 출력////////////////////////////////////////////////
		System.out.println("=================등록된 제품은===================");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));//꺼낼때 .get
		}
		
		/*//검색
		//가격이 3500원 이상인 것을 모두 출력하시오 
		for (int i = 0; i < arr1.size(); i++) {
		    if (arr1.get(i).getPrice() >=3500) {
		          System.out.println(arr1.get(i));
		    }
		} */
        
        //입력에 따른 검색 방법////////////////////////////////////////////
		System.out.print("검색할 가격을 입력하세요 : ");
		
		//입력
		Scanner sc=new Scanner(System.in);
		int ka=Integer.parseInt(sc.next());
		
		//메소드를 사용해서 인자를 보내고 반환 받음 /////////////////////////////////
		ArrayList<SMarket1> arr2=new ArrayList<SMarket1>(); //kaja반환 값을 받기 위한 arr2
		arr2=kaja(arr1,ka); //arr1이 회손 되도 괜찮으면 arr1로 해야하나. 안그러면 새로 만들어 줘야한다.
		
		//검색된 결과 출력
		System.out.println("=================검색된 제품은===================");
		for (int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i));//꺼낼때 .get
		}
		
	}// main end

	//인자를 받아 검색하고 반환하는 메소드////////////////////////////////////////
	private static ArrayList<SMarket1> kaja(ArrayList<SMarket1> arr1, int ka) {
		ArrayList <SMarket1> arr2= new ArrayList<SMarket1>(); //메소드에서 나온 결과를 담는 그릇
		
			for (int i = 0; i < arr1.size(); i++) {
				if (arr1.get(i).getPrice() >= ka) {
					arr2.add(arr1.get(i)); //검색된 값을 arr2에 넣는다. 
				}
			}
			return arr2; //arr2를 반환한다. 
	}

}//class end
