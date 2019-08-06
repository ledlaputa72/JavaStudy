package Day039_GUI_Swing2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableMainClass extends JFrame{
	
	JTable jt1;
	JScrollPane jsp1;
	
	public JTableMainClass() {//생성자
		/*//(1)내부적으로 셀 정리
		DefaultTableCellRenderer dtcr1=new DefaultTableCellRenderer();
		dtcr1.setHorizontalAlignment(JLabel.CENTER);*/
		
		//배열 데이터 
		String[] title = {"사원아이디","이름","전화번호"};
		Object [][] sawons= {//문자열만 처리할 경우 String[][]
				{"s10234","경석","010-5678-2345"},
				{"s10235","미래","010-1234-1234"},
				{"s10236","수아","010-2345-3456"},
				{"s10237","우영","010-3456-6543"},
				{"s10238","정분","010-4567-2222"},
				{"s10239","유은","010-5678-1111"},
				{"s10240","유진","010-6789-7567"},
				{"s10241","현정","010-8765-4564"},
				{"s10242","길동","010-7654-1212"},
				{"s10243","철수","010-5432-9090"},
			}; //배열 종료 
		
		//테이블에 데이터 입력과 설정
		jt1 = new JTable(sawons,title);//내용(데이터),타이틀(컬럼명)
		//해더테이블 칼러와 폰트
		jt1.getTableHeader().setForeground(Color.WHITE);
		jt1.getTableHeader().setBackground(Color.BLACK);
		jt1.getTableHeader().setFont(new Font("굴림",Font.BOLD,25)); //컬럼명 폰트크기 
		//테이블 칼러와 폰트 
		jt1.setGridColor(Color.DARK_GRAY);
		jt1.setBackground(Color.WHITE);
		jt1.setForeground(Color.BLACK);
		jt1.setFont(new Font("굴림",Font.BOLD,25)); //데이터 폰트크기
		
		jt1.setRowHeight(70); //행 높이
		
		//(2)너비조절시 사용 
		jt1.getColumn("사원아이디").setPreferredWidth(200); //열 너비
		jt1.getColumn("이름").setPreferredWidth(200); //열 너비
		jt1.getColumn("전화번호").setPreferredWidth(200); //열 너비
		
		jt1.setValueAt("태희", 7, 1); //7행 1열(현정)을 "태희"로 Change
		System.out.println(jt1.getValueAt(7, 1)); //7행 1열값을 
		jsp1 = new JScrollPane(jt1);
		//JScrollPane 사용시 값이 많고 행이 작으면 테이블에 스크롤이 자동 생성
		
		add(jsp1); //jt1이 포함된 JScrollPane객체 jsp1을 메인 프레임에 add한다. 
		setSize(1000,500);
		setVisible(true);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTableMainClass();

	}

}
