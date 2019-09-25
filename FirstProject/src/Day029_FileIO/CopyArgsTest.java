package Day029_FileIO;

import java.io.*;


public class CopyArgsTest {

	public static void main(String[] args) throws IOException {
		
		int imsi=0;
		FileInputStream fis1=null;
		FileOutputStream fos1=null;
		
		if(args.length>=2) {
			fis1 = new FileInputStream (args[0]);
			fos1 = new FileOutputStream (args[1], false);
			while ((imsi=fis1.read())!=-1) 
				fos1.write(imsi);
			fis1.close();fos1.close();
		}
		
	}//main end
}//class end
