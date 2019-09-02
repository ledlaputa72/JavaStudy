package step01_TCP_SC3_Thread;

import java.net.*;
import java.io.*;

public class CilentMainClass {

	public static void main(String[] args) throws IOException {
		
		File file1=new File("aa.png");
		File file2=new File("aa10.png");
		
		try {
			Socket s1=new Socket("127.0.0.1", 9999);
			
			//로컬 이미지 입력 (입력 소스를 받기) 파일 혹은 화면
			DataInputStream dis1=new DataInputStream(new  FileInputStream(file1)); //간략히
			
			//클라이언트에서 서버로 내보내기 /////////////////////////////////////
			DataOutputStream dos1=new DataOutputStream(s1.getOutputStream()); //네트웤으로 이미지 보내기
			
			//보내기 처리 - byte 배열 이용 ///
			byte[] byteArr1=new byte[(int)file1.length()];
			System.out.println("file ---> byte중...");
			
			//자료 받기 
			dis1.readFully(byteArr1); //파일내용 -->바이트배열
			
			//자료 보내기 
			dos1.writeInt(byteArr1.length);
			dos1.write(byteArr1);
			System.out.println("전송완료...");
			
			System.out.println("서버로 보낸 내용 : "+ byteArr1); //클라에서 서버로 보낸 내용  
			////////////////////////////////////////////////////////////////
			
			
			//서버에서 온 메시지 //////////////////////////////////////////////
			//DataInputStream dis1=new  DataInputStream(s1.getInputStream());
			DataInputStream dis2=new  DataInputStream(s1.getInputStream());
			
			int len1=dis2.readInt(); //서버가 보낸 파일 길이 먼저  받아옴
			byte[] byteArr2=new byte[len1]; //길이만큼 배열을 잡음
			dis2.readFully(byteArr2); //그리고 내용을 받아 바이트배열로
			
			FileOutputStream fos1=new FileOutputStream(file2);
			fos1.write(byteArr2);
			System.out.println("저장완료...");
			
			System.out.println("서버에서 받은 내용 : " + byteArr2);
			///////////////////////////////////////////////////////////////////
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("클라이언트 끝");
	}

}
