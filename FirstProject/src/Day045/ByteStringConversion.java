package Day045;

public class ByteStringConversion {

	public static void main(String[] args) {

		String irum="�´�";
		
		byte[] byteArr=new byte[1024]; //1024ũ�⸸ŭ ��´�. 
		byteArr= irum.getBytes();//String --> Byte �迭��
		//byte ���
		for (int i = 0; i < byteArr.length; i++) {
			System.out.print("byteArr["+i+"]:"+byteArr[i]+", ");			
		}
		System.out.println();
		
		String irum2 = new String(byteArr); //Byte�迭 --> String���� 
		System.out.println(irum2);
		
	}

}
