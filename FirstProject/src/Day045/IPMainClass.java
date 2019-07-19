package Day045;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPMainClass {

	public static void main(String[] args) throws UnknownHostException {
		//Domain Adrress /////////////////////////////////////
		String juso="www.naver.com";
		InetAddress inet1=InetAddress.getByName(juso); //domain name으로 주소 get 
		
		//IP address를 바이트 배열로 변환하고 255형식의 10진수로 바꿔줌 
		byte[] byte4=inet1.getAddress(); //11100111011100
		String change1="";
		for (int i = 0; i < byte4.length; i++) {
			if(byte4[i] < 0){
				change1=change1+(""+(byte4[i]+256));
	//			System.out.print((int)byte4[i]+""+"\t");
			}
			else {
				change1=change1+(""+byte4[i]);
			}
			change1=change1+".";
		}
		System.out.println(change1);
		System.out.println("------------------------------");
		//Domain Name으로 사용 중인 모든 IP Adrress를 검색하여 출력 
		InetAddress [] inetArr1=InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < inetArr1.length; i++) {
			System.out.println(inetArr1[i]);
			System.out.println(inetArr1[i].getHostAddress());
			System.out.println(inetArr1[i].getHostName());
			System.out.println("------------------------------");
		}
	}
}
