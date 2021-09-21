
package gymmanagementsystem.control;

import gymmanagementsystem.model.Client;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Insert_Control {
    String insertStmt="INSERT INTO `clients` (`Name`,`Phone`,`Emergency`,`Type`,`Sessions`) VALUES (?,?,?,?,?)";
    public Client ins(Client c){
         
        try(PreparedStatement pstmt = DB_Connection.connect().prepareStatement(insertStmt, Statement.RETURN_GENERATED_KEYS)){
            //pstmt.setInt(1, Integer.parseInt(c.getId()));
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getPhone());
            pstmt.setString(3, c.getEmergency());
            pstmt.setString(4, c.getType());
            pstmt.setInt(5, c.getSessions());
            pstmt.executeUpdate();
            try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
                if(generatedKeys.next()){
                    c.THEID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Insert_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
