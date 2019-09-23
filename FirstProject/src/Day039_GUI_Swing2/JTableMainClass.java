package Day039_GUI_Swing2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableMainClass extends JFrame{
	
	JTable jt1;
	JScrollPane jsp1;
	
	public JTableMainClass() {//������
		/*//(1)���������� �� ����
		DefaultTableCellRenderer dtcr1=new DefaultTableCellRenderer();
		dtcr1.setHorizontalAlignment(JLabel.CENTER);*/
		
		//�迭 ������ 
		String[] title = {"������̵�","�̸�","��ȭ��ȣ"};
		Object [][] sawons= {//���ڿ��� ó���� ��� String[][]
				{"s10234","�漮","010-5678-2345"},
				{"s10235","�̷�","010-1234-1234"},
				{"s10236","����","010-2345-3456"},
				{"s10237","�쿵","010-3456-6543"},
				{"s10238","����","010-4567-2222"},
				{"s10239","����","010-5678-1111"},
				{"s10240","����","010-6789-7567"},
				{"s10241","����","010-8765-4564"},
				{"s10242","�浿","010-7654-1212"},
				{"s10243","ö��","010-5432-9090"},
			}; //�迭 ���� 
		
		//���̺� ������ �Է°� ����
		jt1 = new JTable(sawons,title);//����(������),Ÿ��Ʋ(�÷���)
		//�ش����̺� Į���� ��Ʈ
		jt1.getTableHeader().setForeground(Color.WHITE);
		jt1.getTableHeader().setBackground(Color.BLACK);
		jt1.getTableHeader().setFont(new Font("����",Font.BOLD,25)); //�÷��� ��Ʈũ�� 
		//���̺� Į���� ��Ʈ 
		jt1.setGridColor(Color.DARK_GRAY);
		jt1.setBackground(Color.WHITE);
		jt1.setForeground(Color.BLACK);
		jt1.setFont(new Font("����",Font.BOLD,25)); //������ ��Ʈũ��
		
		jt1.setRowHeight(70); //�� ����
		
		//(2)�ʺ������� ��� 
		jt1.getColumn("������̵�").setPreferredWidth(200); //�� �ʺ�
		jt1.getColumn("�̸�").setPreferredWidth(200); //�� �ʺ�
		jt1.getColumn("��ȭ��ȣ").setPreferredWidth(200); //�� �ʺ�
		
		jt1.setValueAt("����", 7, 1); //7�� 1��(����)�� "����"�� Change
		System.out.println(jt1.getValueAt(7, 1)); //7�� 1������ 
		jsp1 = new JScrollPane(jt1);
		//JScrollPane ���� ���� ���� ���� ������ ���̺� ��ũ���� �ڵ� ����
		
		add(jsp1); //jt1�� ���Ե� JScrollPane��ü jsp1�� ���� �����ӿ� add�Ѵ�. 
		setSize(1000,500);
		setVisible(true);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTableMainClass();

	}

}
