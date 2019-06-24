package java010_outputStream;
//outputStream
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamEx01 {

	public static void main(String[] args) throws IOException {

//		FileOutputStream fo1=new FileOutputStream("E:/dd.txt", true);
		//메모리에 있는걸 파일로 저장하는 것
		
		FileOutputStream fo1=new FileOutputStream("dd.txt", true); 
		//앞에 E:/를 뺴면 프로젝트 이름 안에 있어야 한다. (src,package가 아니라) 
		
		System.out.println("글자 입력한다. ");
		while (true) {
			int cnt=System.in.available();
			if (cnt>0) {
				System.out.println("입력받은 문자의 길이는 : "+cnt); //입력받은 문자 길이
				byte[] b1=new byte[cnt];
				int bada = System.in.read(b1);
				if(bada==-1) break;
				fo1.write(b1,0,bada); //bada 길이만큼 출력
				System.out.println("수록중");
			}
		}
		fo1.close();
	}//main end

}//class end
