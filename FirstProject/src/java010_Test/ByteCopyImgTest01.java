package java010_Test;
//이미지 byte로 복사해서 새로 만들기
import java.io.*;

public class ByteCopyImgTest01 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream imgCopy=new FileInputStream("e:/test/img.bmp");
		DataInputStream imgCopy2 = new DataInputStream(imgCopy);
		
		FileOutputStream imgPaste=new FileOutputStream("e:/test/img1.png");
		DataOutputStream imgPaste2=new DataOutputStream(imgPaste);
		
    	int imsi=0;
		while ((imsi=imgCopy2.read())!=-1) { //imgCopy의 byte를 imsi에 하나씩 저장 
			imgPaste2.write(imsi); //img2파일에 쓰기
		}
		
        imgCopy.close(); imgPaste.close();
	}

}
