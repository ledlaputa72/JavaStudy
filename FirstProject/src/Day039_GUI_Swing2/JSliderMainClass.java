package Day039_GUI_Swing2;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class JSliderClass extends JFrame implements ChangeListener{
	
	private JSlider jslider1;
	private JTextField jtextfield1;

	public JSliderClass() {
		getContentPane().setLayout(new GridLayout(0,2,20,20));
		//임의 행 5열로 그리고 가로세로 간격은 각각 20픽셀
		
		jslider1=new JSlider(JSlider.VERTICAL, -30,30,20);
		
		//Slider의 major & minor tick mark를 지정한다. 
		jslider1.setMajorTickSpacing(10); //최대 간격, 큰 눈금 : 0 10 20 30 
		jslider1.setMinorTickSpacing(2); //최소 간격, 작은 눈금 : 2씩 
		
		jslider1.setPaintTicks(true);
		jslider1.setPaintLabels(true);
		add(jslider1);
		jslider1.setVisible(true);
		jslider1.addChangeListener(this);
		
		jtextfield1=new JTextField();
		add(jtextfield1);
		jtextfield1.setVisible(true);
		
		this.setSize(1000, 500);
		this.setVisible(true);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==jslider1)
		jtextfield1.setText(""+jslider1.getValue());
	}
}

public class JSliderMainClass {

	public static void main(String[] args) {
		
		new JSliderClass();
	}

}
