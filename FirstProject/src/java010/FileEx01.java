package java010;
// inputStream 
import java.io.FileInputStream;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) throws IOException {

		//���� ���� inputStream
		FileInputStream fis=new FileInputStream("E:/dd.txt");
		
		//���� �а� ����  ouputStream
		int cnt;
		while ((cnt = fis.available())>0) { //�о�ü� �ִ� ����Ʈ ����0����Ʈ �̻��̸�
			byte[] imsi=new byte[cnt]; //����ϱ� ���� �迭b1
			int bada = fis.read(imsi); //b1ũ�⸸ŭ �б�
			//System.out.println(bada); //���ڼ� ���
			if(bada==-1) //bada�� ���̻� ������ ������ -1���� ���´�. 
				break;
			String str1=new String(imsi); //char->String���� �ٲ� 
			//b1[](�迭)�� ���ִ� char���°� String���� �ٲ�� �ȴ�.  
			System.out.println(str1);
			System.out.println("��񸸿�~ ����ϰ� ���ǲ���");
		}
		fis.close();
	}

}
