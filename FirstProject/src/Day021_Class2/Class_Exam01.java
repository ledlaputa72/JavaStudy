package Day021_Class2;

import java.io.ObjectInputStream.GetField;

class CellPhone{
	private String name; //고객명
	private String cpModel;
	private int cpPrice;
	private String cpStore;
	
	//생성자
	public CellPhone(String name, String cpModel, int cpPrice, String cpStore) {
		this.name=name;
		this.cpModel=cpModel;
		this.cpPrice=cpPrice;
		this.cpStore=cpStore;
	}
	
	//setter, getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpModel() {
		return cpModel;
	}
	public void setCpModel(String cpModel) {
		this.cpModel = cpModel;
	}
	public int getCpPrice() {
		return cpPrice;
	}
	public void setCpPrice(int cpPrice) {
		this.cpPrice = cpPrice;
	}
	public String getCpStore() {
		return cpStore;
	}
	public void setCpStore(String cpStore) {
		this.cpStore = cpStore;
	}
	
	public String toString() {
		return this.getName()+" 고객님의 핸드폰 정보는 다음과 같습니다.\n"+"고객님의 "+this.getCpModel()+"의 가격은 "+this.getCpPrice()+"원 이고 구입처는 "+this.getCpStore()+"입니다.";
	}

//  아래와 같이 해도 무관하다. 	
//	public String toString() {
//		return name+" 고객님의 핸드폰 정보는 다음과 같습니다.\n"+"고객님의 "+cpModel+"의 가격은 "+cpPrice+"원 이고 구입처는 "+cpStore+"입니다.";
//	}
	
}//CellPhone class end

public class Class_Exam01 {

	public static void main(String[] args) {
		CellPhone cp1=new CellPhone("홍길동", "아이폰XS", 1500000, "종로지점");
		CellPhone cp2=new CellPhone("이도령", "갤럭시s8", 900000, "강남지점");
		CellPhone cp3=new CellPhone("성춘향", "엘지V7", 800000, "홍대지점");
		CellPhone cp4=new CellPhone("김철수", "갤럭시노트9", 1000000, "구로지점");
		CellPhone cp5=new CellPhone("김영희", "갤럭시S10", 1300000, "건대지점");
		
		System.out.println("------------------------------");
		System.out.println("고객명 \t"+"모델명 \t"+"가격 \t"+"지점 \t");
		System.out.println("------------------------------");
		System.out.println(cp1.getName()+"\t"+cp1.getCpModel()+"\t"+cp1.getCpPrice()+"\t"+cp1.getCpStore()+"\t");
		System.out.println(cp2.getName()+"\t"+cp2.getCpModel()+"\t"+cp2.getCpPrice()+"\t"+cp2.getCpStore()+"\t");
		System.out.println(cp3.getName()+"\t"+cp3.getCpModel()+"\t"+cp3.getCpPrice()+"\t"+cp3.getCpStore()+"\t");
		System.out.println(cp4.getName()+"\t"+cp4.getCpModel()+"\t"+cp4.getCpPrice()+"\t"+cp4.getCpStore()+"\t");
		System.out.println(cp5.getName()+"\t"+cp5.getCpModel()+"\t"+cp5.getCpPrice()+"\t"+cp5.getCpStore()+"\t");
		System.out.println("------------------------------");
		System.out.println();
		
		System.out.println(cp1.toString());
		System.out.println();
		System.out.println(cp2.toString());
		
 	}//main end

}//class end
