package Day038_GUI_AWT6;

import javax.swing.*;
public class JCheckBoxMainClass extends JFrame {
     
     public JCheckBoxMainClass() {
           JPanel jp1=new JPanel();
           JCheckBox jcb1=new JCheckBox("회원카드보유",true);
           JCheckBox jcb2=new JCheckBox("장기회원",true);
           JCheckBox jcb3=new JCheckBox("해외여행신청여부",  false);
           
           jp1.add(jcb1);
           jp1.add(jcb2);
           jp1.add(jcb3);
           getContentPane().add(jp1);
           //프레임의 contentpane을 알아낸후 컴포넌트 부착
           //프레임=메뉴바+contentPane(컴포넌트 붙이는 곳)
     }//생성자 end
     public static void main(String[] args) {
           JCheckBoxMainClass jcbc1 = new JCheckBoxMainClass();
           jcbc1.setTitle("체크박스라는");
           jcbc1.setSize(500, 500);
           jcbc1.setVisible(true);
     }
}