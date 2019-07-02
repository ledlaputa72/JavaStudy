package java_GUI01;

import java.awt.*; 
import java.awt.event.*;


class BMIGUI21 extends Frame implements ActionListener{/////////////
    
	private Button b1=new Button("BMI계산");
    private Label la1=new Label("당신의 키는");
    private Label la2=new Label("당신의 몸무게는");
    private TextField tf1=new TextField();
    private TextField tf2=new TextField();
    private TextField tf3=new TextField();
  // private Frame f1=new Frame("나 프레임이자나");//extends 했으므로 여기서 안함 
    
   
    public BMIGUI21(){ //생성자 
    	this.setLayout(null);////////////
      	//b1=new Button("BMI계산");
    	b1.setFont(new Font("굴림",Font.BOLD,15));
    	b1.setBackground(new Color(204,0,255));
        b1.setSize(100,70);//버튼 크기
        b1.setLocation(200,300); //버튼 내부위치 
	    this.add(b1);//버튼 추가 
        b1.addActionListener(this); //////////////////버튼을 이벤트로 
	  
        
       // la1=new Label("당신의 키는");
        la1.setSize(150,30);
        la1.setLocation(20, 70);//라벨 내부위치 
    	la1.setFont(new Font("굴림",Font.BOLD,15));
    	la1.setBackground(new Color(204,255,0));
    	   
	    this.add(la1);//라벨추가 
        
	   // tf1 =new TextField();
	    tf1.setSize(70,30);
	    tf1.setLocation(200, 70);//텍스트 내부위치 
		tf1.setFont(new Font("굴림",Font.BOLD,15));
		tf1.setBackground(new Color(255,153,204));
	    this.add(tf1); 
	    
	  //  la2=new Label("당신의 몸무게는");
	    la2.setSize(150,30);
        la2.setLocation(20, 100);//라벨 내부위치 
    	la2.setFont(new Font("굴림",Font.BOLD,15));
    	la2.setBackground(new Color(204,255,0));
    	this.add(la2);//라벨추가 

	    //tf2 =new TextField();
	    tf2.setSize(70,30);
	    tf2.setLocation(200, 100);//텍스트 내부위치 
		tf2.setFont(new Font("굴림",Font.BOLD,15));
		tf2.setBackground(new Color(255,153,204));
	    this.add(tf2); 

	    //tf3 =new TextField();
	    tf3.setSize(400,50);
	    tf3.setLocation(20,400);//텍스트 내부위치 
		tf3.setFont(new Font("굴림",Font.BOLD,15));
		tf3.setBackground(new Color(255,255,0));
	    this.add(tf3);
	    
	    this.setSize(500, 500); //프레임 크기 
	    this.setBackground(new Color(255,240,245));//창문배경색
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
 
    	if(e1.getSource() == b1){ //버튼이 눌러졌으면(이벤트) 
    	   try { ///////////////		
    		int  ki= Integer.parseInt(tf1.getText());
            int  mom=Integer.parseInt(tf2.getText());
    	  
          double mki=ki/100.0;
          double bmi=mom / Math.pow(mki,2);
      
          String result;
          if(bmi >=30.0)  	   result="비만";
          else if(bmi >=25.0)  result="과체중";
          else if(bmi >=20.0)  result="보통";
          else result="저체중";
     tf3.setText("당신의 bmi지수는"+Math.round(bmi)+"이며"
        	                           +result+"이군요"); 
    	  }catch(NumberFormatException e){//////////
    	     tf3.setText("키와 몸무게에 숫자를 넣어주세요"); 
    	  }catch(Exception e){////////////////
    		   tf3.setText(e.getMessage());   }
    	}//if-end
    }//actionPerformed-end
 }//class-BMIGUI2-end
public class BMIGUI2 {

	public static void main(String[] args) {
		BMIGUI2 b=new BMIGUI2(); //가즈아!!! 생성자로 
	
	}
}

