package java007_Date;

import java.util.Date;

public class DateStudy002 {

	public static void main(String[] args) {

		Date d1=new Date(); //���� class
		String s1=d1.toLocaleString(); //��ü.�޼ҵ�()
		
		String[] arr={"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
		String str1="������ ";
		str1 += (d1.getYear()+1900)+"�� ";
		str1 += (d1.getMonth()+1)+"�� ";
		str1 += (d1.getDate())+"�� ";
		str1 += arr[d1.getDay()]+"�Դϴ�";
		System.out.println(str1);
		
		
		//��п��� 1000ms ��ŭ ����� �ð�
		// ����:1970�� 1�� 1�� 0�� 0�� 0�� (UTC(����������), GMT(�׸���ġ õ���� �ð�))
		Date d22=new Date(1000L); //long int 8����Ʈ, 1000L�� 1000ms�� �ǹ� 
		String s22=d22.toLocaleString();
		System.out.println("���ؿ��� 1�� ������ : "+s22);
	}

}
