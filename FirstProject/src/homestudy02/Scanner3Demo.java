package homestudy02;

import java.util.*;
import java.io.*;

public class Scanner3Demo {

	public static void main(String[] args) {

		try {
			File file=new File("dd.txt");
			Scanner sc= new Scanner(file);
			while (sc.hasNextInt()) {
				System.out.println(sc.nextInt()*1000);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
