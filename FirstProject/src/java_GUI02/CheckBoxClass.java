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
		
		cbc1.setLayout(new FlowLayout());//가로 정렬
		cbc1.add(cb1);
		cbc1.add(cb2);
		cbc1.add(cb3);
		//cbc1.pack();//프레임크기를 포함된 컴포넌트에 맞추라는 것 
		cbc1.setSize(300, 300);
		cbc1.setVisible(true);
		
		cbc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cbc1.dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});	//창 닫기
		
	}//main end

}
