
package gymmanagementsystem.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Scan_Control {
    public int scan(int id){
        int sessions = 0;
        int ret = 0;
        Statement stat = null;
        try {
            stat = DB_Connection.connect().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Scan_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = null;
        try {
            res = stat.executeQuery("SELECT * FROM clients WHERE ID = '"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Scan_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(res.next()){
                try {
                    sessions = res.getInt(6);
                } catch (SQLException ex) {
                    Logger.getLogger(Scan_Control.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(sessions>0){
                    sessions--;
                    stat.executeUpdate("UPDATE `clients` SET `Sessions` = '"+sessions+"' WHERE `clients`.`ID` ="+ id+"");
                    ret = sessions;
                }
                else{
                    System.out.println("Finished Membership");
                    ret= 0;
                }
            }
            else{
                System.out.println("Not Found ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Scan_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
