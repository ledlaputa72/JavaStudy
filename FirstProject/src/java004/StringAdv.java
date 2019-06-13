package java004;

class Sangpum{
	private String irum;
	private int ka;
	private String company;
	private String jijeom;

	//������
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
	
	//��� to String
	public String toString() {
		return "[ǰ��]:"+this.getIrum()+" [����]:"+this.getKa()/10000+"����"+" [����ȸ��]:"+this.getCompany()+" [�Ǹ�ó]:"+this.getJijeom();
	}
	
}

public class StringAdv {

	public static void main(String[] args) {
		
		//���ڿ� -> �迭�� 
		String pummok="bag,150000,coacha,jongro"; //���ڿ�
		String[] arr=pummok.split(","); 
		
		//��ü ������ ��� 
		Sangpum bag=new Sangpum(arr[0],Integer.parseInt(arr[1]),arr[2],arr[3]); //��ü ����
		System.out.println(bag.toString());
	}

}
