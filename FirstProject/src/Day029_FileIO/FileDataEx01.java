package Day029_FileIO;
//����Ʈ ���� ������ ���� ����
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDataEx01 {

	public static void main(String[] args) throws IOException {
		
		//1. ���Ͽ� �����͸� �����Ѵ�./////////////////////////////////////// 
		FileOutputStream fos2 = new FileOutputStream("e:/cc.txt");
		DataOutputStream dos2 = new DataOutputStream(fos2);
		
		//fos2�� ����� �� ������ dos2�� ���� �ִ�. ����� dos2�� ���� �ִ�. 
		dos2.writeInt(10); //10�� int(4����Ʈ)�� ����.  
		dos2.writeBoolean(false); //�Ҹ�(1byte)���� ����.
		dos2.writeShort(Short.MAX_VALUE); //32767 (2byte)
		dos2.writeLong(Long.MIN_VALUE); // (8byte)
		dos2.writeUTF("�氡�氡");//���ڿ�
		
		dos2.close();fos2.close();// �������� ���������� �ݴ� ������ �ؾ��Ѵ�. 
		
	}

}
