package java010;
// inputStream 
import java.io.FileInputStream;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) throws IOException {

		//���� ���� inputStream
		FileInputStream f1=new FileInputStream("E:/dd.txt");
		
		//���� �а� ����  ouputStream
		int cnt;
		while ((cnt = f1.available())>0) { //�о�ü� �ִ� ����Ʈ ����0����Ʈ �̻��̸�
			byte[] b1=new byte[cnt]; //����ϱ� ���� �迭b1
			int bada = f1.read(b1); //b1ũ�⸸ŭ �б�
			//System.out.println(bada); //���ڼ� ���
			if(bada==-1) //bada�� ���̻� ������ ������ -1���� ���´�. 
				break;
			String str1=new String(b1); //char->String���� �ٲ� 
			//b1[](�迭)�� ���ִ� char���°� String���� �ٲ�� �ȴ�.  
			System.out.println(str1);
			System.out.println("��񸸿�~ ����ϰ� ���ǲ���");
		}
		f1.close();
	}

}
