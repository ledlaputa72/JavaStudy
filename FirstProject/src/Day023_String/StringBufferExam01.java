package Day023_String;

public class StringBufferExam01 {

	public static void main(String[] args) {

		String aa="babo";
		String bb="ondal"; 
		String cc=aa+bb;
		//--------------------
		String s1="java";
		String s2="java"; //String�� ������ �Ȱ�����, ���� �޸� �ּҿ� ������. 
		if(s1==s2) { //���� ��
			System.out.println("�̰� �������?1"); //���� �ּҶ� ��µȴ�. 
		}
		if(s1.equals(s2)) { //���� ��
			System.out.println("�̰� �������?1����"); //���� �����̶� ��µȴ�. 
		}
		
		StringBuffer sb1=new StringBuffer("java");
		StringBuffer sb5=new StringBuffer("java"); //StringBuffer�� ���� ����������, �޸� �ּҰ� ���� ������.
		if(sb1==sb5) { //���� ��
			System.out.println("�̰� �������?2"); //�ٸ� �ּҶ� ����� �ȵȴ�. 
		}
		if(sb1.equals(sb5)) { //���� ��
			System.out.println("�̰� �������?2����"); //���� ���������� ��������. 
		}
		if(sb1.toString().equals(sb5.toString())) { //������ ��� �ȴ�.
			System.out.println("�̰� �������?2����2");
		}
		//-----------------------
		
		StringBuffer sb2=new StringBuffer(10);
		
		System.out.println("sb1.length : "+sb1.length());
		System.out.println("sb2.length : "+sb2.length());
		
		sb2.append("java"); //java
		
		sb2.reverse(); //avaj
		System.out.println(sb2.toString()); //avaj
		System.out.println(sb2); //avaj
		
		sb2.delete(1, 2);
		System.out.println(sb2.toString()); //aaj
		
		sb2.replace(0, 2, "va");
		System.out.println(sb2.toString()); //vaj
		
		System.out.println("���ڿ� ���� ���� sb2.length : "+sb2.length()); //3
		
	} //main end

}//class end
