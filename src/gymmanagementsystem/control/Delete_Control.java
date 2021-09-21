
package gymmanagementsystem.control;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Delete_Control {
    Statement st;
    public void delete(int id){
        try {
            st = DB_Connection.connect().createStatement();
            st.executeUpdate("DELETE FROM clients WHERE ID = '"+id+"'");
        } 
        catch (SQLException ex) {
            Logger.getLogger(Insert_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
