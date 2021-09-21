
package gymmanagementsystem.control;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Update_Control {
    public void update(int id,String name,String phone,String emergency,String type, int sessions){
        Statement stat = null;
        boolean flag = false;
        try {
            stat = DB_Connection.connect().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Update_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stat.executeUpdate("UPDATE `clients` SET `Name` = '"+name+"', `Phone` = '"+phone+"', `Emergency` = '"+emergency+"', `Type` = '"+type+"', `Sessions` = '"+sessions+"' WHERE `ID` ="+id+"");
        } catch (SQLException ex) {
            Logger.getLogger(Update_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
