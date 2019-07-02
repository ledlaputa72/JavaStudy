package java_GUI02;

import java.awt.*;
import java.awt.event.*;

public class RadioButtonClass extends Frame {

	public static void main(String[] args) {
		
		RadioButtonClass rbc1=new RadioButtonClass();
		rbc1.setTitle("체크박스");
		CheckboxGroup ck1=new CheckboxGroup(); //라디오버튼을 만들때 사용
		Checkbox cb1=new Checkbox("사과",ck1, false); 
		Checkbox cb2=new Checkbox("배",ck1, true); //디폴트 선택 
		Checkbox cb3=new Checkbox("감",ck1, false);
		
		rbc1.setLayout(new FlowLayout());//가로 정렬
		rbc1.add(cb1);
		rbc1.add(cb2);
		rbc1.add(cb3);
		//cbc1.pack();//프레임크기를 포함된 컴포넌트에 맞추라는 것 
		rbc1.setSize(300, 300);
		rbc1.setVisible(true);
		
		rbc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				rbc1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
		
	}

}
