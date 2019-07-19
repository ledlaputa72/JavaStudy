package Day045;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPMainClass {

	public static void main(String[] args) throws UnknownHostException {
		//Domain Adrress /////////////////////////////////////
		String juso="www.naver.com";
		InetAddress inet1=InetAddress.getByName(juso); //domain name으로 주소 get 
		
		//InetAddress 클래스는 IP주소표현을 우해 사용///////////////////
//		InetAddress inet1=InetAddress.getLocalHost(); //클래스명.ststic 메소드  (new 객체 없이 사용) 
		
		//자신이 사용중인 localhost(127.0.0.1)의 iNetAddress객체 
		System.out.println(inet1.getHostAddress()); //Sting	//dotted decimal address
		System.out.println(inet1.getHostName()); //String)//domain name 
		
		//IP address를 바이트 배열로 변환해줌 
		byte[] byte4=inet1.getAddress(); //11100111011100
		for (int i = 0; i < byte4.length; i++) {
			System.out.print((int)byte4[i]+""+"\t");
		}
		System.out.println();
		
		//Domain Name으로 사용 중인 모든 IP Adrress를 검색하여 출력 
		InetAddress [] inetArr1=InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < inetArr1.length; i++) {
			System.out.println(inetArr1[i]);
			System.out.println(inetArr1[i].getHostAddress());
			System.out.println(inetArr1[i].getHostName());
		}
	}
}
