package java004;

import java.util.Scanner;

public class ArrayArgTest {

	public static void main(String[] args) {

		String str= "kongjoo";
        char[] ch2=str.toCharArray(); // String -> char[]
		//  'k'   'o'   'n'   'g' ...
        // ch[0] ch[1] ch[2] ch[3]
        
        ch2[4]='b'; //'j'�� 'b'�� ����
        
        String str2=new String(ch2); // char -> String���� ��ȯ�ϱ� ���� ���ο� ���� ����
        
        System.out.print(str2);
        
	}

}
