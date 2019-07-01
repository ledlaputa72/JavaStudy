package Java_GUI01;

import java.awt.FlowLayout;
import java.awt.Frame;

public class TextFieldClass extends Frame {

	public static void main(String[] args) {

		TextFieldClass tfc1=new TextFieldClass(); //메인프레임
		tfc1.setSize(500, 500);	
		tfc1.setTitle("텍스트필드란");
		tfc1.setLayout(new FlowLayout()); //행단위별 추가시 
	}
}

