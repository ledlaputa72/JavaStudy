package java010;
//문자열 단위 저장

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStringEx01 {
	//TextViewer 
	public static void main(String[] args) throws IOException {
		
		FileReader fr1=new FileReader("e:/aa.txt"); //문자열 단위 파일 read
		BufferedReader br1=new BufferedReader(fr1); //문자열 도우미 
		String s =null;
		//file read - 화면 write
		while ((s=br1.readLine())!=null) { //한줄의 끝 null, 한글자씩의 끝 eof, -1
			System.out.println(s);
		}
		br1.close(); fr1.close();
	}

}
