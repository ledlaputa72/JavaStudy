package java004;

class Sangpum{
	private String irum;
	private int ka;
	private String company;
	private String jijeom;

	//생성자
	public Sangpum(String irum, int ka, String company, String jijeom) {
		this.irum=irum;
		this.ka=ka;
		this.company=company;
		this.jijeom=jijeom;
	}
	
	//getter, setter
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public int getKa() {
		return ka;
	}
	public void setKa(int ka) {
		this.ka = ka;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJijeom() {
		return jijeom;
	}
	public void setJijeom(String jijeom) {
		this.jijeom = jijeom;
	}
	
	//출력 to String
	public String toString() {
		return "[품명]:"+this.getIrum()+" [가격]:"+this.getKa()/10000+"만원"+" [제조회사]:"+this.getCompany()+" [판매처]:"+this.getJijeom();
	}
	
}

public class StringAdv {

	public static void main(String[] args) {
		
		//문자열 -> 배열로 
//		String pummok="bag,150000,coacha,jongro"; //문자열
//		String[] arr=pummok.split(",");
		
		String pummok="bag**150000**coacha**jongro"; //**를 구분자로
		String[] arr=pummok.split("\\*\\*"); 
		
		//객체 생성과 출력 
		Sangpum bag=new Sangpum(arr[0],Integer.parseInt(arr[1]),arr[2],arr[3]); //객체 생성
		
		/* //선생님 방법
		 * Sangpum sp1=new Sangpum();//sp1 객체 하나만들고 
		 * String[] arr=pummok.split(",");  
		 * sp1.setIrum{arr[0]);//품목명
		 * sp1.setKa{Integer.valueOf(arr[0]));//가격
		 * sp1.setCompany{arr[0]);//제조회사
		 * sp1.setJijeom{arr[0]); //판매처
		 */
		System.out.println(bag.toString());
	}

}
