package java010_Test;
//�̹��� byte�� �����ؼ� ���� �����
import java.io.*;

public class ByteCopyImgTest01 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream imgCopy=new FileInputStream("e:/test/img.bmp");
		DataInputStream imgCopy2 = new DataInputStream(imgCopy);
		
		FileOutputStream imgPaste=new FileOutputStream("e:/test/img1.png");
		DataOutputStream imgPaste2=new DataOutputStream(imgPaste);
		
    	int imsi=0;
		while ((imsi=imgCopy2.read())!=-1) { //imgCopy�� byte�� imsi�� �ϳ��� ���� 
			imgPaste2.write(imsi); //img2���Ͽ� ����
		}
		
        imgCopy.close(); imgPaste.close();
	}

}
