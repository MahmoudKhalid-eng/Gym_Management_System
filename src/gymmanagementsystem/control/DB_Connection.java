
package gymmanagementsystem.control;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB_Connection {
    private DB_Connection(){
        
    }
    private static Connection con = null;
    private static final String url = "jdbc:mysql://localhost/gym";
    private static final String username = "root";
    private static final String password = "";
    public static Connection connect() throws SQLException{
        if(con == null){
            con = (Connection) DriverManager.getConnection(url, username, password);
        }
        
        return con;
    }
}
