package telinfoDBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TelInfoDBConn {
    private Connection con; 
    
    public Connection getConnection() { 
           return con;
    }
    
    public TelInfoDBConn () throws ClassNotFoundException, SQLException {
           Class.forName("org.mariadb.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mariadb://ledlaputa.com:3306/ledlaputa",  "ledlaputa", "Ilovejayjung1!");
    }
}