package telinfoDBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TelInfoDBConn {
    private Connection con; //���� ��ü
    
    public Connection getConnection() { //ȣ��� getConnection() �޼ҵ带 ���
           return con;
    }
    
    public TelInfoDBConn () throws ClassNotFoundException, SQLException {
           Class.forName("oracle.jdbc.driver.OracleDriver");
               //����̹� �޸� �ε�
           con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",  "hr", "hr");
    }
}