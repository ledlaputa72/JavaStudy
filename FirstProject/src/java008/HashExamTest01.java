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
	
		HashStudient hs1=new HashStudient("멋쟁이", 100, 100, 100);
		HashStudient hs2=new HashStudient("왕자", 90, 90, 100);
		HashStudient hs3=new HashStudient("공주", 100, 95, 100);
		
		hms1.put(new Integer(100),hs1);
		hms1.put(new Integer(200),hs2);
		hms1.put(new Integer(300),hs3);
		
		/*
		hms1.put(new Integer(100),new HashStudient("멋쟁이", 100, 100, 100));
		//위의 내용을 한줄에 넣을 수 있다. hs1=new HashStudient("멋쟁이", 100, 100, 100)
		*/
		

		System.out.println("이름"+"\t"+"국어성적"+"\t"+"영어성적"+"\t"+"수학성적"+"\t");
		System.out.println("------------------------------");
		
		// 하나씩 찍어서 처리 - 메소드 사용X   
		/*System.out.println(hms1.get(100).getName()+"\t"+hms1.get(100).getKor()+"\t"+hms1.get(100).getEng()+"\t"+hms1.get(100).getMat()+"\t");
		System.out.println(hms1.get(200).getName()+"\t"+hms1.get(200).getKor()+"\t"+hms1.get(200).getEng()+"\t"+hms1.get(200).getMat()+"\t");
		System.out.println(hms1.get(300).getName()+"\t"+hms1.get(300).getKor()+"\t"+hms1.get(300).getEng()+"\t"+hms1.get(300).getMat()+"\t");
		*/
				
		kajaScore(hms1); //배열로 전달해서 메소드로 처리한다. 
		
	} //main end

	private static void kajaScore(HashMap<Integer, HashStudient> hms1) {
		Set <Integer> set1 = hms1.keySet();
        for(Integer i:set1) { //set1은 key값만 들어가 있다. 
            // for( : )은 뒤에서 끄집어 내고 다 끄집어 낼때 까지 반복하는 조건
			System.out.println(hms1.get(i).getName()+"\t"+hms1.get(i).getKor()+"\t"+hms1.get(i).getEng()+"\t"+hms1.get(i).getMat()+"\t");
		}
	}// kajaScore end
	
}//class end





