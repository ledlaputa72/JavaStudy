package Day038_GUI_AWT6;

import javax.swing.*;
public class JCheckBoxMainClass extends JFrame {
     
     public JCheckBoxMainClass() {
           JPanel jp1=new JPanel();
           JCheckBox jcb1=new JCheckBox("ȸ��ī�庸��",true);
           JCheckBox jcb2=new JCheckBox("���ȸ��",true);
           JCheckBox jcb3=new JCheckBox("�ؿܿ����û����",  false);
           
           jp1.add(jcb1);
           jp1.add(jcb2);
           jp1.add(jcb3);
           getContentPane().add(jp1);
           //�������� contentpane�� �˾Ƴ��� ������Ʈ ����
           //������=�޴���+contentPane(������Ʈ ���̴� ��)
     }//������ end
     public static void main(String[] args) {
           JCheckBoxMainClass jcbc1 = new JCheckBoxMainClass();
           jcbc1.setTitle("üũ�ڽ����");
           jcbc1.setSize(500, 500);
           jcbc1.setVisible(true);
     }
}