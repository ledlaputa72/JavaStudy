package java_GUI01;

import java.awt.*; 
import java.awt.event.*;


class BMIGUI21 extends Frame implements ActionListener{/////////////
    
	private Button b1=new Button("BMI���");
    private Label la1=new Label("����� Ű��");
    private Label la2=new Label("����� �����Դ�");
    private TextField tf1=new TextField();
    private TextField tf2=new TextField();
    private TextField tf3=new TextField();
  // private Frame f1=new Frame("�� ���������ڳ�");//extends �����Ƿ� ���⼭ ���� 
    
   
    public BMIGUI21(){ //������ 
    	this.setLayout(null);////////////
      	//b1=new Button("BMI���");
    	b1.setFont(new Font("����",Font.BOLD,15));
    	b1.setBackground(new Color(204,0,255));
        b1.setSize(100,70);//��ư ũ��
        b1.setLocation(200,300); //��ư ������ġ 
	    this.add(b1);//��ư �߰� 
        b1.addActionListener(this); //////////////////��ư�� �̺�Ʈ�� 
	  
        
       // la1=new Label("����� Ű��");
        la1.setSize(150,30);
        la1.setLocation(20, 70);//�� ������ġ 
    	la1.setFont(new Font("����",Font.BOLD,15));
    	la1.setBackground(new Color(204,255,0));
    	   
	    this.add(la1);//���߰� 
        
	   // tf1 =new TextField();
	    tf1.setSize(70,30);
	    tf1.setLocation(200, 70);//�ؽ�Ʈ ������ġ 
		tf1.setFont(new Font("����",Font.BOLD,15));
		tf1.setBackground(new Color(255,153,204));
	    this.add(tf1); 
	    
	  //  la2=new Label("����� �����Դ�");
	    la2.setSize(150,30);
        la2.setLocation(20, 100);//�� ������ġ 
    	la2.setFont(new Font("����",Font.BOLD,15));
    	la2.setBackground(new Color(204,255,0));
    	this.add(la2);//���߰� 

	    //tf2 =new TextField();
	    tf2.setSize(70,30);
	    tf2.setLocation(200, 100);//�ؽ�Ʈ ������ġ 
		tf2.setFont(new Font("����",Font.BOLD,15));
		tf2.setBackground(new Color(255,153,204));
	    this.add(tf2); 

	    //tf3 =new TextField();
	    tf3.setSize(400,50);
	    tf3.setLocation(20,400);//�ؽ�Ʈ ������ġ 
		tf3.setFont(new Font("����",Font.BOLD,15));
		tf3.setBackground(new Color(255,255,0));
	    this.add(tf3);
	    
	    this.setSize(500, 500); //������ ũ�� 
	    this.setBackground(new Color(255,240,245));//â������
	    this.setVisible(true);
	    
		//this.addWindowListener(new WindowDada());
	    addWindowListener(new WindowAdapter(){ //////////////////
	    	 public void windowClosing(WindowEvent e1){
	    		 dispose();
	    		 System.exit(0);
	    		 
	    	 }
	    }); //////////////////////////////////////////
    }
    public void actionPerformed(ActionEvent e1){//
 
    	if(e1.getSource() == b1){ //��ư�� ����������(�̺�Ʈ) 
    	   try { ///////////////		
    		int  ki= Integer.parseInt(tf1.getText());
            int  mom=Integer.parseInt(tf2.getText());
    	  
          double mki=ki/100.0;
          double bmi=mom / Math.pow(mki,2);
      
          String result;
          if(bmi >=30.0)  	   result="��";
          else if(bmi >=25.0)  result="��ü��";
          else if(bmi >=20.0)  result="����";
          else result="��ü��";
     tf3.setText("����� bmi������"+Math.round(bmi)+"�̸�"
        	                           +result+"�̱���"); 
    	  }catch(NumberFormatException e){//////////
    	     tf3.setText("Ű�� �����Կ� ���ڸ� �־��ּ���"); 
    	  }catch(Exception e){////////////////
    		   tf3.setText(e.getMessage());   }
    	}//if-end
    }//actionPerformed-end
 }//class-BMIGUI2-end
public class BMIGUI2 {

	public static void main(String[] args) {
		BMIGUI2 b=new BMIGUI2(); //�����!!! �����ڷ� 
	
	}
}

