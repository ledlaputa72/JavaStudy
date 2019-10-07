package Day029_FileIO;

import java.io.*;

public class StringCopyTest03 {

	public static void main(String[] args) throws IOException {

        ///////임시 저장소 aaa->ccc, bbb->aaa, ccc->aaa
        String imsi=null; 
		
        //aaa -> ccc
		FileReader fr3=new FileReader("e:/aaa.txt"); //1.aaa파일 읽어오기
		BufferedReader br3=new BufferedReader(fr3); 
        
		FileWriter fw5=new FileWriter("e:/ccc.txt", false); //2.ccc파일에 쓰기 
		BufferedWriter bw5=new BufferedWriter(fw5);
		PrintWriter pw5=new PrintWriter(bw5, true); 
        
        while ((imsi=br3.readLine())!=null) {  //br3(aaa) -> ccc(imsi)
            pw5.println(imsi);  
            System.out.println(imsi);
       }
        
        //bbb->aaa
		FileReader fr4=new FileReader("e:/bbb.txt"); //3.bbb파일 읽어오기 
		BufferedReader br4=new BufferedReader(fr4); 
        
		FileWriter fw3=new FileWriter("e:/aaa.txt", false); //4.aaa파일에 쓰기
		BufferedWriter bw3=new BufferedWriter(fw3);
		PrintWriter pw3=new PrintWriter(bw3, true); 
        
        while ((imsi=br4.readLine())!=null) {  //br3(aaa) -> ccc(imsi)
            pw3.println(imsi);  
            System.out.println(imsi);
       }
        
        //ccc->bbb
		FileReader fr5=new FileReader("e:/ccc.txt"); //5.ccc파일 읽어오기
		BufferedReader br5=new BufferedReader(fr5); 
        
		FileWriter fw4=new FileWriter("e:/bbb.txt", false); //6.bbb파일에 쓰기 
		BufferedWriter bw4=new BufferedWriter(fw4);
		PrintWriter pw4=new PrintWriter(bw4, true); 
        
        while ((imsi=br5.readLine())!=null) {  //br3(aaa) -> ccc(imsi)
            pw4.println(imsi);  
            System.out.println(imsi);
       }
        br3.close();pw3.close(); br4.close();pw4.close(); br5.close();pw5.close();
		
	}

}
