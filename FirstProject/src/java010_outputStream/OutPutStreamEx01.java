package java010_outputStream;
//outputStream
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamEx01 {

	public static void main(String[] args) throws IOException {

//		FileOutputStream fo1=new FileOutputStream("E:/dd.txt", true);
		//�޸𸮿� �ִ°� ���Ϸ� �����ϴ� ��
		
		FileOutputStream fo1=new FileOutputStream("dd.txt", true); 
		//�տ� E:/�� ���� ������Ʈ �̸� �ȿ� �־�� �Ѵ�. (src,package�� �ƴ϶�) 
		
		System.out.println("���� �Է��Ѵ�. ");
		while (true) {
			int cnt=System.in.available();
			if (cnt>0) {
				System.out.println("�Է¹��� ������ ���̴� : "+cnt); //�Է¹��� ���� ����
				byte[] b1=new byte[cnt];
				int bada = System.in.read(b1);
				if(bada==-1) break;
				fo1.write(b1,0,bada); //bada ���̸�ŭ ���
				System.out.println("������");
			}
		}
		fo1.close();
	}//main end

}//class end
