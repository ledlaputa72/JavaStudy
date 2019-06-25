package java010;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDateEx02 {

	public static void main(String[] args) throws IOException {

		//2. 저장된 파일을 꺼내본다./////////////////////////////////////////
		FileInputStream fis2=new FileInputStream("e:/cc.txt");
		DataInputStream dis2=new DataInputStream(fis2);
		
		//저장된 내용을 데이터형에 맞추어 출력한다. 
		System.out.println(dis2.readInt());
		System.out.println(dis2.readBoolean());
//		System.out.println(dis2.readShort());
		System.out.printf("16진주로 출력하면 %x 구나\n",dis2.readShort()); //순서대로 찌어야 함 
		System.out.println(dis2.readLong());
		System.out.println(dis2.readUTF());
		
		//c언어 스타일로, printf("틀",자료,자료), 
		//pritf("오늘은 날씨좋으니 %s를 %d번 연습  해야지.\n","자바",10); (%s="자바", %d=10)
		// 결과 : 오늘은 날씨 좋으니 자바를 10번 연습 해야지. (줄바꿈) 
		
		dis2.close();fis2.close(); 
		
	}

}
