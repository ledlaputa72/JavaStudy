package java010;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDateEx02 {

	public static void main(String[] args) throws IOException {

		//2. ����� ������ ��������./////////////////////////////////////////
		FileInputStream fis2=new FileInputStream("e:/cc.txt");
		DataInputStream dis2=new DataInputStream(fis2);
		
		//����� ������ ���������� ���߾� ����Ѵ�. 
		System.out.println(dis2.readInt());
		System.out.println(dis2.readBoolean());
//		System.out.println(dis2.readShort());
		System.out.printf("16���ַ� ����ϸ� %x ����\n",dis2.readShort()); //������� ���� �� 
		System.out.println(dis2.readLong());
		System.out.println(dis2.readUTF());
		
		//c��� ��Ÿ�Ϸ�, printf("Ʋ",�ڷ�,�ڷ�), 
		//pritf("������ ���������� %s�� %d�� ����  �ؾ���.\n","�ڹ�",10); (%s="�ڹ�", %d=10)
		// ��� : ������ ���� ������ �ڹٸ� 10�� ���� �ؾ���. (�ٹٲ�) 
		
		dis2.close();fis2.close(); 
		
	}

}
