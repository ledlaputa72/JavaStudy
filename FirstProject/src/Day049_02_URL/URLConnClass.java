package Day049_02_URL;

import java.io.*;
import java.net.*;

public class URLConnClass {

	public static void main(String[] args) throws IOException {
		
		URL url1=new URL(args[0]);
		URLConnection urlconn1=url1.openConnection();
		//url보다 상세한 결과 얻음
		
		BufferedReader br1=new BufferedReader(new InputStreamReader((InputStream)urlconn1.getContent()));
		//getContent: URL의 내용을 얻음
		
		System.out.println(urlconn1.getURL()); //URL얻기
		System.out.println(urlconn1.getContentLength()); //ContentLength header
		System.out.println(urlconn1.getContentType()); //ContentType haeder
		
		System.out.println("=======================================");
		
		String jool;
		while ((jool=br1.readLine()) != null) {
			System.out.println(jool); //내용 출력
		}
	}
}
