package java010;

import java.io.*;

public class StringCopyTest01 {

	public static void main(String[] args) throws IOException {

		FileReader fr2=new FileReader("e:/copy.txt"); //파일을 오픈
        BufferedReader br2=new BufferedReader(fr2); //버퍼에 저장
//        BufferedReader br2=new BufferedReader(new FileReader("e:/copy.txt")); //축약
        
        FileWriter fw2=new FileWriter("e:/paste.txt", false); //저장 파일을 오픈
        BufferedWriter bw2=new BufferedWriter(fw2); //버퍼에 저장
        PrintWriter pw2=new PrintWriter(bw2, true); 
//        PrintWriter pw2 = new PrintWriter(new BufferedWriter (new FileWriter("e:/paste.txt", false)),true); //축약
        
        String st2 =null;
        while ((st2=br2.readLine())!=null) { //br2 버퍼의 내용을 불러와 st2에 하나씩 저장한다. 
             pw2.println(st2); //st2에 저장된 내용을 pw2 버퍼를 통해 파일에 기록한다. 
             System.out.println(st2); //내용을 확인해 보기 위해서 
        }
        
        br2.close(); fw2.close();pw2.close();
        
	}

}
