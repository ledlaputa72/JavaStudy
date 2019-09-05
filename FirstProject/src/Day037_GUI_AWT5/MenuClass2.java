package Day037_GUI_AWT5;
//one class ��� 
import java.awt.CheckboxMenuItem;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuClass2 extends Frame implements ActionListener{
	
	TextArea ta1;
	//������
	public MenuClass2 () {
		
		MenuBar mb1=new MenuBar(); //�޴��� ��ü
		
		//1��° �޴� : ���� �޴��� ��ü, �����۰� �̺�Ʈ ������
		Menu m1=new Menu("����");//1�� �޴� ��ü ���� 
		
		MenuItem it1=new MenuItem("����");
		MenuItem it2=new MenuItem("����");
		MenuItem it3=new MenuItem("�ٸ��̸���������");
		MenuItem it4=new MenuItem("����");
		
		it1.addActionListener(this);
		it2.addActionListener(this);
		it3.addActionListener(this);
		it4.addActionListener(this);
		
		m1.add(it1); //m1�� �θ޴� add (����)
		m1.addSeparator();
		m1.add(it2); //����
		m1.add(it3); //�ٸ��̸�����
		m1.addSeparator();
		m1.add(it4); //����
		
		mb1.add(m1); //�ָ޴�(m1)�� �޴���(mb1)���� add
		
		//2��° �޴�
		Menu m2=new Menu("����");//2�� �޴� ��ü ���� 
		
		MenuItem it5=new MenuItem("��μ���");
		CheckboxMenuItem it6=new CheckboxMenuItem("�˻�"); //�޴� �տ� V(üũ)�� ǥ�õǴ� ��� ��� �޴� �������̴�. 
		CheckboxMenuItem it7=new CheckboxMenuItem("����");
		
		it5.addActionListener(this);
		it6.addActionListener(this);
		it7.addActionListener(this);
		
		m2.add(it5); 
		m2.add(it6); 
		m2.add(it7); 
		
		mb1.add(m2); //�ָ޴�(m1)�� �θ޴���(mb2)���� add
		
		setMenuBar(mb1);
		
		ta1=new TextArea();
		add(ta1);
	
		
		//�ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}//������ ����
	

	public static void main(String[] args) {
		
		MenuClass2 mc1=new MenuClass2();
		mc1.setSize(500, 500);
		mc1.setTitle("�޴�");
		//mc1.pack();
		mc1.setVisible(true);
		
		
	}
	
	//�̺�Ʈ �ڵ鷯 //////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		//���� ���� ///////////////////////////////////////////////////////////////////////
		if("����".equals(e.getActionCommand())) { 
			FileDialog fd1= new FileDialog(this, "�� ���Ͽ�����", FileDialog.LOAD); 
			fd1.setVisible(true);
			if (fd1.getFile()==null) {
				return; 
			}
			String fname1=fd1.getDirectory()+fd1.getFile();
			BufferedReader br1=null;
				try {
					br1 = new BufferedReader(new FileReader(fname1)); 
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
				ta1.setText(""); 
				
				//���Ͽ��� �о ����  ////////////////////////////////////////////
				String s1;
				try {
					while ((s1=br1.readLine())!=null) { 
						ta1.append(s1+"\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//�бⰡ ���� br1�� ���� 
				try {
					br1.close(); 
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				setTitle("���������� "+fd1.getFile()); 
		}//���� ���� ��
		
		
		
		//���� �ٸ��̸����� �����ϱ� 
		else if("�ٸ��̸���������".equals(e.getActionCommand())) {
			FileDialog fd2= new FileDialog(this, "�� ���������̶��", FileDialog.SAVE); 
			fd2.setVisible(true);
			if (fd2.getFile()==null) {
				return; //������ �������� ������ ���� 
			}
			
			//���� ��ġ�� �����Ѵ�. 
			String fname2=fd2.getDirectory()+fd2.getFile(); //������ ������ ����
			BufferedWriter bw1=null;
				try {
					bw1 = new BufferedWriter(new FileWriter(fname2)); //���ٸ� ġ���� try~catch�� �ڵ� ����
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //
				
			try {
				bw1.write(ta1.getText());
				//�̹� TextArea�� ������ �̹� lineSkip(\n)�� �����Ƿ� ����ÿ� �ٹٲ��� �ȴ�. 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bw1.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setTitle("���������� "+fd2.getFile());
		}//���� ���� ����
		
		//���� ��ư 
		else if ("����".equals(e.getActionCommand())) {
			System.exit(0);
		}
	}//ActionPerformed() end
}//class end

