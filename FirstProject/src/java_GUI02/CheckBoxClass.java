package java_GUI02;

import java.awt.*;
import java.awt.event.*;

//편의상 one class로 main에서 하고 있음  
public class CheckBoxClass extends Frame {

	public static void main(String[] args) {

		CheckBoxClass cbc1=new CheckBoxClass();
		cbc1.setTitle("체크박스");
		Checkbox cb1=new Checkbox("사과",true); //디폴트로 체크표시
		Checkbox cb2=new Checkbox("배",true);
		Checkbox cb3=new Checkbox("감",true);
		
		
	}

}
