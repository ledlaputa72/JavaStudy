package java007_Test_SMarket;

import java.util.*;

//SMarket 클래스 ////////////////////////////////////////
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
	
	//getter setter///////////////////////////////
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

	//출력//////////////////////////////////////////////////
	@Override
	public String toString() {
		return "[제품명 : " + name +"\t"+ "| 가격 : " + price +"\t"+ "| 매대 : " + counter+" ]";
	}
	
}// SMarket end

//main 클래스 ////////////////////////////////////////////
public class Main {

	public static void main(String[] args) {
		//메뉴 번호 선택 
		Scanner sc=new Scanner(System.in);
		
		//상품의 입력을 위한 컬랙션 리스트 
		ArrayList<SMarket> arr1=new ArrayList<SMarket>(); //
		
		//입력한 초기 데이터
		kajaData(arr1);
         
		//메뉴 프로그램
		int selectMenu;
		do {
			kajaMenu(); //메뉴 내용 
			
			//번호를 입력 받는다. 
			selectMenu=sc.nextInt();
			
			switch (selectMenu) {
			case 0: //0) 전체 상품 보기 메소드 
				kajaList(arr1);
				selectMenu=kajaYes(selectMenu); //초기 메뉴 복귀 메소드			
				break;
			case 1: //1) 상품 입력 메소드
				kajaCreate(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 2: //2) 상품 수정 메소드
				kajaUpdate(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 3: //3) 상품 검색 메소드
				kajaSearch(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 4: //4) 상품 삭제 메소드
				kajaDelete(arr1);
				selectMenu=kajaYes(selectMenu);	
				break;
			case 5: //5) 종료 
				System.out.println("------------------------------------------");
				System.out.println("프로그램을 종료합니다. ");
				System.exit(0);
				break;
			default:
				System.out.println("------------------------------------------");
				System.out.println("선택을 잘못 했습니다. 다시하세요");
				System.out.println("------------------------------------------");
			}
		} while (selectMenu!=0 && selectMenu!=1 && selectMenu!=2 && selectMenu!=3 && selectMenu!=4&& selectMenu!=5);
		
	} //main end
	
	
	//초기 입력 데이터 ///////////////////////////////////////
	private static void kajaData(ArrayList<SMarket> arr1) {

		 arr1.add(new SMarket("서울우유",2500,"A"));
         arr1.add(new SMarket("액티비아",3000,"A"));
         arr1.add(new SMarket("이오",2000,"A"));
         arr1.add(new SMarket("매일우유",2300,"A"));
         arr1.add(new SMarket("남양우유",2300,"A"));
         arr1.add(new SMarket("서울치즈",4000,"B"));
         arr1.add(new SMarket("코카콜라",1500,"C"));
         arr1.add(new SMarket("스프라이트",1400,"C"));
         arr1.add(new SMarket("썬키스트",4500,"D"));
		
	}

	//관리 메뉴 /////////////////////////////////////////////
	private static void kajaMenu() {

		System.out.println("=========== SMarket 관리 프로그램 메뉴 ===========");
		System.out.println("0) 전체 상품 보기");
		System.out.println("1) 상품 입력");
		System.out.println("2) 상품 수정");
		System.out.println("3) 상품 검색");
		System.out.println("4) 상품 삭제");
		System.out.println("5) 종료");
		System.out.println("------------------------------------------");
		System.out.println("\t"+"\t"+"\t"+"메뉴를 선택하세요 (0-5)");
		System.out.println("==========================================");
		
	}

	//메뉴 이동 메소드////////////////////////////////////////
	private static int kajaYes(int selectMenu) {
		Scanner sc=new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("\t"+"\t"+"메뉴로 이동하시겠습니까? 1.Yes/2.No");
		int YesOrNo=sc.nextInt();
		if (YesOrNo==1) {
			selectMenu=-1;
		}
		else {
			System.out.println("------------------------------------------");
			System.out.println("프로그램을 종료합니다. ");
			selectMenu=sc.nextInt();
			System.exit(0);
		}
		return selectMenu;
		
	}

	//0) 전체 상품 보기 메소드 ///////////////////////////////////
	private static void kajaList(ArrayList<SMarket> arr1) {
		
		System.out.println("===============  전체 상품 보기  ===============");
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(arr1.get(i));
       }
//        System.out.println("==========================================");
	}

	//1) 상품 입력 메소드///////////////////////////////////////
	private static void kajaCreate(ArrayList<SMarket> arr1) {
		System.out.println("---------------상품을 입력하세요 ---------------");
		System.out.println("현재 총 "+(arr1.size())+"개 입니다. ");
		
 		Scanner sc=new Scanner(System.in); //입력 받기 
 		
		System.out.print("이름을 입력하세요 : ");
		String sc11=sc.next();
		System.out.print("가격을 입력하세요 : ");
		int sc12=sc.nextInt();
		System.out.print("매대를 입력하세요 : ");
		String sc13=sc.next();
 		
 		arr1.add(new SMarket(sc11, sc12, sc13));//입력 받은 값을 클래스에 입력 
 		
 		System.out.println("==========================================");
 		System.out.println("추가된 상품의 정보입니다. ");
 		System.out.println(arr1.get(arr1.size()-1));
        System.out.println("현재 총 "+(arr1.size())+"개 입니다. ");
//        System.out.println("==========================================");
           
	}

	//2) 상품 수정 메소드/////////////////////////////////////////
	private static void kajaUpdate(ArrayList<SMarket> arr1) {
		System.out.println("------------------상품 수정------------------");
		System.out.print("검색할 상품명을 입력하세요 : ");
 		
 		Scanner sc=new Scanner(System.in);
 		String sc1=sc.next();
 		
 		//검색찾고 수정될 항목을 입력 받아 수정함 
		for (int i = 0; i < arr1.size(); i++) {
				if (sc1.equals(arr1.get(i).getName())) { //항목 검색
					System.out.println("검색된 상품의 결과는 아래와 같습니다.");
					System.out.println(arr1.get(i)); //
					
					System.out.print("이름을 수정하세요 : ");
					String sc11=sc.next();
					System.out.print("가격을 수정하세요 : ");
					int sc12=sc.nextInt();
					System.out.print("매대를 수정하세요 : ");
					String sc13=sc.next();
					System.out.println("----------------------------------------");
					arr1.set(i, new SMarket(sc11, sc12, sc13));
					System.out.println("수정된 상품은 아래와 같습니다. ");
					System.out.println(arr1.get(i));
			}
		}
//        System.out.println("==========================================");
	} //상품 수정 메소드 end
	
	//3) 상품 검색 메소드////////////////////////////////////////
	private static void kajaSearch(ArrayList<SMarket> arr1) {
		System.out.println("------------------상품 검색-------------------");
		System.out.print("검색할 상품명을 입력하세요 : ");
		
		Scanner sc=new Scanner(System.in);
		String sc1=sc.next(); //입력받은 값을 String sc1으로 
		
		//검색찾기 
		int sw=0;
		for (int i = 0; i < arr1.size(); i++) {
			if (sc1.equals(arr1.get(i).getName())) { //항목 검색
				System.out.println("검색된 상품의 결과는 아래와 같습니다.");
				System.out.println(arr1.get(i)); //
				sw=1;
			}
			else {
				break;
			}
		}
		if (sw==0) {
			System.out.println("!!!!!검색한 물품을 찾을 수 없습니다.!!!!! ");
		}
		
		
		
		
	} //상품 검색 메소드 end
	
	//4) 상품 삭제 메소드//////////////////////////////////////////////
	private static void kajaDelete(ArrayList<SMarket> arr1) {
		System.out.println("--------------상품 삭제----------------");
		System.out.println("삭제할 상품명을 입력하세요 ");
		
		Scanner sc=new Scanner(System.in);
		String sc1=sc.next();
		
		//검색삭제
		for (int i = 0; i < arr1.size(); i++) {
			if (sc1.equals(arr1.get(i).getName())) { //입력한 단어를 찾아서 같으면 출력
				System.out.println(arr1.get(i));
				System.out.println("삭제 하시겠습니까? [1.Yes/2.No]");
				int YesOrNo=sc.nextInt();
				if (YesOrNo==1) {
					arr1.remove(i); //해당 제품을 삭제 
					System.out.println("----------------------------------------");
					System.out.println(sc1+"제품이 삭제되었습니다.");
				}
				else {
					System.out.println("----------------------------------------");
					System.out.println("취소되었습니다."); 
					break;
				}
				
			}
		}
	} //kajaDelete end

}//class end
