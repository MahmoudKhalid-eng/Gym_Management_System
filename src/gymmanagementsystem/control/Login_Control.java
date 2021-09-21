
package gymmanagementsystem.control;

import gymmanagementsystem.model.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Login_Control {
    public boolean isAdmin(Admin ad) throws SQLException{
        Statement st;
        st = DB_Connection.connect().createStatement();
        ResultSet res = st.executeQuery("select * from admin where username = '"+ad.getUsername()+"'and password = '"+ad.getPassword()+"'" );
        
        if(res.next()){
            return true;
        }
        else{
            return false;
        }
    }
}
