package Day029_FileIO;
//바이트 단위 데이터 파일 저장
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDataEx01 {

	public static void main(String[] args) throws IOException {
		
		//1. 파일에 데이터를 저장한다./////////////////////////////////////// 
		FileOutputStream fos2 = new FileOutputStream("e:/cc.txt");
		DataOutputStream dos2 = new DataOutputStream(fos2);
		
		//fos2에 적어야 될 내용을 dos2에 쓰고 있다. 도우미 dos2에 쓰고 있다. 
		dos2.writeInt(10); //10을 int(4바이트)로 쓴다.  
		dos2.writeBoolean(false); //불린(1byte)으로 쓴다.
		dos2.writeShort(Short.MAX_VALUE); //32767 (2byte)
		dos2.writeLong(Long.MIN_VALUE); // (8byte)
		dos2.writeUTF("방가방가");//문자열
		
		dos2.close();fos2.close();// 닫을때는 열었을때의 반대 순서로 해야한다. 
		
	}

}
