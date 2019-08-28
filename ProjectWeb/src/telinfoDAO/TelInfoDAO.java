package telinfoDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import telinfoDBConn.TelInfoDBConn;
import telinfoVO.TelInfoVO;

public class TelInfoDAO {
	
	private Connection con;
	PreparedStatement pstmt = null; 
	ResultSet rs = null; //종이 박스 
	
	public TelInfoDAO() throws ClassNotFoundException, SQLException{
		con=new TelInfoDBConn().getConnection();	//접속 객체 생성
	}
	
	public void pstmtClose() throws SQLException { //pstmt 닫을때 
		if(pstmt != null) {pstmt.close();}
	} 
	
	public void getAllInfoClose() throws SQLException { //rs 닫을때는 모두 닫는 메소드 사용
		if(rs != null ) {rs.close();}
		if(pstmt != null) {pstmt.close();}
		if(con != null) {con.close();}
	}
	
	//전체를 인원을 찾는 메소드 /////////////////////////////////////
	public ArrayList<TelInfoVO> getAllInfo() throws SQLException {
		ArrayList<TelInfoVO> tiarray = new ArrayList<TelInfoVO>();
		String sql = "SELECT * FROM TelTable5 ORDER BY id"; //선택문
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			Date d = rs.getDate("d");
			
			TelInfoVO tv = new TelInfoVO(id,name,tel,d);
			tiarray.add(tv);
		}
		return tiarray; //tiarray //리턴 반환값(ArrayList<TelInfoVO>)
	}// getAllInfo() end///////////////////////////////////////
	
	//원하는 한사람 찾는 메소드 ///////////////////////////////////////
	public TelInfoVO search_nametel(String oriName) throws SQLException { 
		TelInfoVO tv = null; //한사람만 찾음 
		String sql = "SELECT * FROM TelTable5 WHERE NAME=?"; //? : 원하는 사람 이름 선택문
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, oriName);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			Date d = rs.getDate("d"); //홍길동 정보 전부 꺼내서 
			
			tv=new TelInfoVO(id,name,tel,d); //vo 그릇에 넣고 //생성자로 가서 
		} else { //그런 이름이 없으면
			tv=null; //tv객체 참조 변수에 null (return null)
		}
		return tv; //그런 이름이 있으면 tv 리턴 //반환값(TelInfoVO)
	} //search_nametel() end/////////////////////////////////////
	
	//전화번호를 바꾸고 업데이트 == 수정 메소드 /////////////////////////////
	public boolean update_nametel (String tel2, String name2) {
		String sql = "UPDATE TelTable5 SET tel=? WHERE name=?";
		try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,  tel2);
				pstmt.setString(2,  name2);
				
				pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("update Exception");
			e.printStackTrace();
//			return false;
		}
		return true;
	}//update_nametel end //////////////////////////////////////
	
	
}//class end
