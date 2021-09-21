
package gymmanagementsystem.control;

import gymmanagementsystem.model.Client;
import gymmanagementsystem.model.SearchRes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Level;
import javafx.collections.ObservableList;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Search_Control {
    Statement st;
    ResultSet res;
    Client c = null;
    public Client search(int id) throws SQLException{
        try {
            st = DB_Connection.connect().createStatement();
            res = st.executeQuery("select * from clients where ID = '"+id+"'");
        } 
        catch (SQLException ex) {
            Logger.getLogger(Insert_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(res.next()){
            c =new Client();
            c.setSessions(res.getInt(6));
            c.THEID(res.getInt(1));
            c.setName(res.getString(2));
            c.setPhone(res.getString(3));
            c.setEmergency(res.getString(4));
            c.setType(res.getString(5));
        }
         
        return c;
    }
    public Boolean idCheck(int id){
        Boolean flag = true;
        try {
            st = DB_Connection.connect().createStatement();
            res = st.executeQuery("select * from clients where ID = '"+id+"'");
        } 
        catch (SQLException ex) {
            Logger.getLogger(Insert_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(res.next()){
                flag = true;
            }
            else{
                flag = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Search_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
