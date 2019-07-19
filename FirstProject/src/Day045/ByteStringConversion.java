package Day045;

public class ByteStringConversion {

	public static void main(String[] args) {

		String irum="온달";
		
		byte[] byteArr=new byte[1024];
		byteArr= irum.getBytes();//String --> Byte 배열로
		//byte 출력
		for (int i = 0; i < byteArr.length; i++) {
			System.out.print(byteArr[i]+"\t");			
		}
		System.out.println();
		
		String irum2 = new String(byteArr); //Byte배열 --> String으로 
		System.out.println(irum2);
		
	}

}
