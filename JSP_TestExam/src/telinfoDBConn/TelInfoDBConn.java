package telinfoDBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TelInfoDBConn {
    private Connection con; //접속 객체
    
    public Connection getConnection() { //호출시 getConnection() 메소드를 사용
           return con;
    }
    
    public TelInfoDBConn () throws ClassNotFoundException, SQLException {
           Class.forName("oracle.jdbc.driver.OracleDriver");
               //드라이버 메모리 로딩
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",  "hr", "hr");
    }
}