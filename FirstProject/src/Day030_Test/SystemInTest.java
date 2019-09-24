package Day030_Test;

import java.io.IOException;

public class SystemInTest {

	public static void main(String[] args) throws IOException {

		System.out.println("Press ENTER key after type an one of Alphabat.");
		
		int i;
		try {
			/*i=System.in.read();
			System.out.println(i);
			System.out.println((char)i);*/
			while ((i=System.in.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
