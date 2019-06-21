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
		System.out.println(hms1.size()); //0
		
		HashStudient hs1=new HashStudient("¸ÚÀïÀÌ", 100, 100, 100);
		HashStudient hs2=new HashStudient("¿ÕÀÚ", 90, 90, 100);
		HashStudient hs3=new HashStudient("°øÁÖ", 100, 95, 100);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(hs1.getEng());

		}
		
		
		hms1.put(new Integer(100),hs1);
		hms1.put(new Integer(200),hs2);
		hms1.put(new Integer(300),hs3);
		
		Set<Integer> s1=hms1.keySet();
        System.out.println(s1);
        
        Collection <HashStudient> v1=hms1.values();
        System.out.println(v1);
	}
}
