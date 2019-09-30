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
    ResultSet rs = null; 
    
    public TelInfoDAO() throws ClassNotFoundException, SQLException{
           con=new TelInfoDBConn().getConnection(); 
    }

    public ArrayList<TelInfoVO> getAllInfo() throws SQLException {
           ArrayList<TelInfoVO> tiarray = new ArrayList<TelInfoVO>();
           String sql = "SELECT * FROM Sawon ORDER BY id"; 
           
           pstmt = con.prepareStatement(sql);
           rs = pstmt.executeQuery();
           while(rs.next()) {
                  int id = rs.getInt("id");
                  String name = rs.getString("name");
                  String tel = rs.getString("tel");
                  
                  TelInfoVO tv = new TelInfoVO(id,name,tel);
                  tiarray.add(tv);
           }
           return tiarray; 
    }// getAllInfo() end///////////////////////////////////////
} //class TelInfoDAO end
