package java005;

public class StringBufferExam01 {

	public static void main(String[] args) {

		String aa="babo";
		String bb="ondal"; 
		String cc=aa+bb;
		//--------------------
		String s1="java";
		String s2="java"; //String은 내용이 똑같으면, 같은 메모리 주소에 잡힌다. 
		if(s1==s2) { //번지 비교
			System.out.println("이게 찍힐까요?1"); //같은 주소라 출력된다. 
		}
		if(s1.equals(s2)) { //내용 비교
			System.out.println("이게 찍힐까요?1내용"); //같은 내용이라 출력된다. 
		}
		
		StringBuffer sb1=new StringBuffer("java");
		StringBuffer sb5=new StringBuffer("java"); //StringBuffer는 같은 내용이지만, 메모리 주소가 따로 잡힌다.
		if(sb1==sb5) { //번지 비교
			System.out.println("이게 찍힐까요?2"); //다른 주소라 출력이 안된다. 
		}
		if(sb1.equals(sb5)) { //내용 비교
			System.out.println("이게 찍힐까요?2내용"); //같은 내용이지만 안찍힌다. 
		}
		//-----------------------
		
		StringBuffer sb2=new StringBuffer(10);
		
		System.out.println("sb1.length : "+sb1.length());
		System.out.println("sb2.length : "+sb2.length());
	}

}
