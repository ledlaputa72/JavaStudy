package java005;

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
		//-----------------------
		
		StringBuffer sb2=new StringBuffer(10);
		
		System.out.println("sb1.length : "+sb1.length());
		System.out.println("sb2.length : "+sb2.length());
	}

}
