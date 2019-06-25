package java010;

import java.io.*;


public class StringCopyTest04 {

	public static void main(String[] args) throws IOException {

		 String imsi=null; //ccc ÀúÀå
		 
		 // aaa->ccc
		 BufferedReader br3=new BufferedReader(new FileReader("e:/aaa.txt")); 
		 PrintWriter pw5=new PrintWriter(new BufferedWriter(new FileWriter("e:/ccc.txt", false)), true); 
		 while ((imsi=br3.readLine())!=null) 
            pw5.println(imsi);
		 br3.close();pw5.close();
		 
		 // bbb->aaa
	     BufferedReader br4=new BufferedReader(new FileReader("e:/bbb.txt"));
	     PrintWriter pw3=new PrintWriter(new BufferedWriter(new FileWriter("e:/aaa.txt", false)), true);
	     while ((imsi=br4.readLine())!=null) 
            pw3.println(imsi);  
	     br4.close();pw3.close(); 
	     
	     // ccc->bbb
	     BufferedReader br5=new BufferedReader(new FileReader("e:/ccc.txt")); 
	     PrintWriter pw4=new PrintWriter(new BufferedWriter(new FileWriter("e:/bbb.txt", false)), true);
	     while ((imsi=br5.readLine())!=null) 
            pw4.println(imsi);  
	     pw4.close(); br5.close();
	}
}
