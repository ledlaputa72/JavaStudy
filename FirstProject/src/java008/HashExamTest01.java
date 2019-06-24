package java008;

import java.util.*;

class HashStudient{
	private String name;
	private int kor;
	private int eng;
	private int mat;
		
	public HashStudient() {
		super();
	}
	
	public HashStudient(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
}

public class HashExamTest01 {

	public static void main(String[] args) {
		
		HashMap <Integer, HashStudient> hms1=new HashMap <Integer, HashStudient>();
//		System.out.println(hms1.size()); //0
	
		HashStudient hs1=new HashStudient("������", 100, 100, 100);
		HashStudient hs2=new HashStudient("����", 90, 90, 100);
		HashStudient hs3=new HashStudient("����", 100, 95, 100);
		
		hms1.put(new Integer(100),hs1);
		hms1.put(new Integer(200),hs2);
		hms1.put(new Integer(300),hs3);
		
		/*
		hms1.put(new Integer(100),new HashStudient("������", 100, 100, 100));
		//���� ������ ���ٿ� ���� �� �ִ�. hs1=new HashStudient("������", 100, 100, 100)
		*/
		

		System.out.println("�̸�"+"\t"+"�����"+"\t"+"�����"+"\t"+"���м���"+"\t");
		System.out.println("------------------------------");
		
		// �ϳ��� �� ó�� - �޼ҵ� ���X   
		/*System.out.println(hms1.get(100).getName()+"\t"+hms1.get(100).getKor()+"\t"+hms1.get(100).getEng()+"\t"+hms1.get(100).getMat()+"\t");
		System.out.println(hms1.get(200).getName()+"\t"+hms1.get(200).getKor()+"\t"+hms1.get(200).getEng()+"\t"+hms1.get(200).getMat()+"\t");
		System.out.println(hms1.get(300).getName()+"\t"+hms1.get(300).getKor()+"\t"+hms1.get(300).getEng()+"\t"+hms1.get(300).getMat()+"\t");
		*/
				
		kajaScore(hms1); //�迭�� �����ؼ� �޼ҵ�� ó���Ѵ�. 
		
	} //main end

	private static void kajaScore(HashMap<Integer, HashStudient> hms1) {
		Set <Integer> set1 = hms1.keySet();
        for(Integer i:set1) { //set1�� key���� �� �ִ�. 
            // for( : )�� �ڿ��� ������ ���� �� ������ ���� ���� �ݺ��ϴ� ����
			System.out.println(hms1.get(i).getName()+"\t"+hms1.get(i).getKor()+"\t"+hms1.get(i).getEng()+"\t"+hms1.get(i).getMat()+"\t");
		}
	}// kajaScore end
	
}//class end





