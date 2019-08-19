package step01_TCP_SC3_Thread;

import java.io.*;
import java.net.*;

public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		
		
		try {
			ServerSocket ss1=new ServerSocket(9999);
			System.out.println("서버 대기중 ....");
			
			while(true) {
				Socket s1=ss1.accept();
				System.out.println("접속자 정보 : "+s1.toString());
				
				//이미지 받기 <--  서버 //////////////////////////////////////////
				DataInputStream dis1=new DataInputStream(s1.getInputStream()); //네트웤으로 이미지 받기 
				
				int len1=dis1.readInt(); //서버가 보낸 파일 길이 먼저  받아옴
				byte[] byteArr1=new byte[len1]; //길이만큼 배열을 잡음
				dis1.readFully(byteArr1); //dis1에서 받은 내용을 byteArr에 저장 
				System.out.println("이미지 받음....");
				
				System.out.println("클라에서 받은 내용 : "+ byteArr1); //네트웍으로 받은 클라이언트의 내용 출력 		
				/////////////////////////////////////////////////////////////////
				
				//이미지 보내기 --> 클라 /////////////////////////////////////////
				DataOutputStream dos1=new DataOutputStream(s1.getOutputStream()); //네트웤으로 이미지 보내기
				
				//보내기 처리 - byte 배열 이용 //////////////////////
//				byteArr2= new byte[byteArr1.length];	//파일 길이만큼 배열 잡음 
				
				//자료 보내기 
				dos1.writeInt(byteArr1.length);
				dos1.write(byteArr1);
				System.out.println("이미지 보냄....");
				
				System.out.println("서버로 보낸 내용 : "+ byteArr1); //네트웍으로 클라에서 받아 다시 서버에서 클라로 보낸 내용 
				////////////////////////////////////////////////////////////////				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
