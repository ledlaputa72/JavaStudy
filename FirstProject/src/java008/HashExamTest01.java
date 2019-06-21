package java008;

import java.util.HashMap;

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
		
		
		}

}
