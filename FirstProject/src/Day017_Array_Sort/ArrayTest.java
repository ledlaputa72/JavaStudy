package Day017_Array_Sort;

public class ArrayTest {

	public static void main(String[] args) {
		// �迭 
		// ���� ó�� ����
		/*
		int kor,eng,mat,soc,sci;
		kor=90;
		eng=100;
		mat=30;
		soc=70;
		sci=80;
		
		int total=kor+eng+mat+soc+sci;
		double avg=total/5.0;
				
		System.out.println("total= "+total);
		System.out.println("avarage= "+avg);
		*/
		
		// �迭 ����
		/*int[] jum = new int[5];
		jum[0]=100;
		jum[1]=80;
		jum[2]=30;
		jum[3]=70;
		jum[4]=80;*/
		// ������ �迭 ���� 
		int[] jum={100,90,30,50,80}; //���� ������ ���ٷ� ���� 
		
		int total=0;
		for(int i=0; i<5; i++) {
			total = total+jum[i]; //���� ����, �ʱ�ġ 
		}
		System.out.println(total);
		System.out.println(total/5.0);
		
		 // �Ǽ��� ���� �迭
		double [] dd = new double[3];
		dd[2]=3.14;
		System.out.println(dd[2]);
		
		 // ���ڿ� ���� �迭
		String[] str1= new String[3];
		str1[0]="babo";
		str1[1]="kongju";
		System.out.println(str1[0]+" "+str1[1]);
		
		// char �迭
		char[] ch1=new char[2];
		ch1[0]='A';
		System.out.println(ch1[0]);
		
		// double �迭�� ����ȭ
		double [] ddd= {3.14, 5.34, 2.34};
		System.out.println(ddd[0]+ddd[1]);
		
		//String �迭�� ����ȭ 
		String [] str2={"babo", "ondal", "merong"};
		System.out.println(str2[0]+str2[1]+str2[2]);
		
		
		
	}

}
