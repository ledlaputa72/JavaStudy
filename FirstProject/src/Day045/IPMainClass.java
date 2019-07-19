package Day045;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPMainClass {

	public static void main(String[] args) throws UnknownHostException {
		//Domain Adrress /////////////////////////////////////
		String juso="www.naver.com";
		InetAddress inet1=InetAddress.getByName(juso); //domain name���� �ּ� get 
		
		//InetAddress Ŭ������ IP�ּ�ǥ���� ���� ���///////////////////
//		InetAddress inet1=InetAddress.getLocalHost(); //Ŭ������.ststic �޼ҵ�  (new ��ü ���� ���) 
		
		//�ڽ��� ������� localhost(127.0.0.1)�� iNetAddress��ü 
		System.out.println(inet1.getHostAddress()); //Sting	//dotted decimal address
		System.out.println(inet1.getHostName()); //String)//domain name 
		
		//IP address�� ����Ʈ �迭�� ��ȯ���� 
		byte[] byte4=inet1.getAddress(); //11100111011100
		for (int i = 0; i < byte4.length; i++) {
			System.out.print((int)byte4[i]+""+"\t");
		}
		System.out.println();
		
		//Domain Name���� ��� ���� ��� IP Adrress�� �˻��Ͽ� ��� 
		InetAddress [] inetArr1=InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < inetArr1.length; i++) {
			System.out.println(inetArr1[i]);
			System.out.println(inetArr1[i].getHostAddress());
			System.out.println(inetArr1[i].getHostName());
		}
	}
}
