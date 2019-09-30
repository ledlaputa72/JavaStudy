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
           con=new TelInfoDBConn().getConnection(); //접속 객체 생성
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
} //class TelInfoDAO end
