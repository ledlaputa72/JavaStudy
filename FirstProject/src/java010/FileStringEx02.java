package java010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileStringEx02 {

	public static void main(String[] args) throws IOException {
		
		//키보드 입력 도우미 ///////////////////////////////////////////////////
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in)); //아래 축약형 (2줄을 1줄로)
		//InputStreamReader isr1=new InputStreamReader(System.in);
		//BufferedReader br1=new BufferedReader(isr1); //isr1 자리에 new InputStreamReader(System.in) 가 들어감
		
		//출력을 위해 /////////////////////////////////////////////////////////
		FileWriter fw1=new FileWriter("e:/cc.txt", false); 
		BufferedWriter bw1=new BufferedWriter(fw1); //출력(파일에 수록) 도우미 1
		PrintWriter pw1=new PrintWriter(bw1, true); //출력을 쉽게 해주는 도우미 2
		
		//처리 
		System.out.println("입력하세요. 끝나면 ctrl+z");
		String st =null;
		while ((st=br1.readLine())!=null) { //키보드로 부터 처리 함 
			pw1.println(st);
		}
		br1.close();pw1.close(); bw1.close();fw1.close();
	}

}
