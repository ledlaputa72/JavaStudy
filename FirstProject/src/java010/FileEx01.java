package java010;
// inputStream 
import java.io.FileInputStream;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) throws IOException {

		//파일 오픈 inputStream
		FileInputStream fis=new FileInputStream("E:/dd.txt");
		
		//파일 읽고 쓰기  ouputStream
		int cnt;
		while ((cnt = fis.available())>0) { //읽어올수 있는 바이트 수가0바이트 이상이면
			byte[] imsi=new byte[cnt]; //출력하기 위한 배열b1
			int bada = fis.read(imsi); //b1크기만큼 읽기
			//System.out.println(bada); //글자수 출력
			if(bada==-1) //bada는 더이상 읽을게 없으면 -1값을 갖는다. 
				break;
			String str1=new String(imsi); //char->String으로 바꿈 
			//b1[](배열)에 들어가있는 char형태가 String으로 바뀌게 된다.  
			System.out.println(str1);
			System.out.println("잠깐만요~ 출력하고 가실께요");
		}
		fis.close();
	}

}
