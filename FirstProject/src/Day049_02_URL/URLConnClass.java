package Day049_02_URL;

import java.io.*;
import java.net.*;

public class URLConnClass {

	public static void main(String[] args) throws IOException {
		
		URL url1=new URL(args[0]);
		URLConnection urlconn1=url1.openConnection();
		//url���� ���� ��� ����
		
		BufferedReader br1=new BufferedReader(new InputStreamReader((InputStream)urlconn1.getContent()));
		//getContent: URL�� ������ ����
		
		System.out.println(urlconn1.getURL()); //URL���
		System.out.println(urlconn1.getContentLength()); //ContentLength header
		System.out.println(urlconn1.getContentType()); //ContentType haeder
		
		System.out.println("=======================================");
		
		String jool;
		while ((jool=br1.readLine()) != null) {
			System.out.println(jool); //���� ���
		}
	}
}
