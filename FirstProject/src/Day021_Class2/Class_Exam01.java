package Day021_Class2;

import java.io.ObjectInputStream.GetField;

class CellPhone{
	private String name; //����
	private String cpModel;
	private int cpPrice;
	private String cpStore;
	
	//������
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
		return this.getName()+" ������ �ڵ��� ������ ������ �����ϴ�.\n"+"������ "+this.getCpModel()+"�� ������ "+this.getCpPrice()+"�� �̰� ����ó�� "+this.getCpStore()+"�Դϴ�.";
	}

//  �Ʒ��� ���� �ص� �����ϴ�. 	
//	public String toString() {
//		return name+" ������ �ڵ��� ������ ������ �����ϴ�.\n"+"������ "+cpModel+"�� ������ "+cpPrice+"�� �̰� ����ó�� "+cpStore+"�Դϴ�.";
//	}
	
}//CellPhone class end

public class Class_Exam01 {

	public static void main(String[] args) {
		CellPhone cp1=new CellPhone("ȫ�浿", "������XS", 1500000, "��������");
		CellPhone cp2=new CellPhone("�̵���", "������s8", 900000, "��������");
		CellPhone cp3=new CellPhone("������", "����V7", 800000, "ȫ������");
		CellPhone cp4=new CellPhone("��ö��", "�����ó�Ʈ9", 1000000, "��������");
		CellPhone cp5=new CellPhone("�迵��", "������S10", 1300000, "�Ǵ�����");
		
		System.out.println("------------------------------");
		System.out.println("���� \t"+"�𵨸� \t"+"���� \t"+"���� \t");
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
