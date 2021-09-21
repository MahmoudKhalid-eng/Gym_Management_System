
package gymmanagementsystem.control;

import gymmanagementsystem.model.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Clients_Control {
    public ObservableList<Client> getAllClients(){
        ObservableList client = FXCollections.observableArrayList();
        Statement stat = null;
        try {
            stat = DB_Connection.connect().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Clients_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = null;
        try {
            res = stat.executeQuery("SELECT * FROM clients");
        } catch (SQLException ex) {
            Logger.getLogger(Clients_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(res.next()){
                Client obj =new Client();
                obj.setSessions(res.getInt(6));
                obj.THEID(res.getInt(1));
                obj.setName(res.getString(2));
                obj.setPhone(res.getString(3));
                obj.setEmergency(res.getString(4));
                obj.setType(res.getString(5));
                client.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clients_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
    public ObservableList<Client> getClient(int id) throws SQLException{
        ObservableList client = FXCollections.observableArrayList();
        Statement stat = null;
        try {
            stat = DB_Connection.connect().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Clients_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet res = null;
        try {
            res = stat.executeQuery("SELECT * FROM clients WHERE ID = '"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Clients_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(res.next()){
                Client obj =new Client();
                System.out.println(res.getInt(1));
                obj.setSessions(res.getInt(6));
                obj.THEID(res.getInt(1));
                obj.setName(res.getString(2));
                obj.setPhone(res.getString(3));
                obj.setEmergency(res.getString(4));
                obj.setType(res.getString(5));
                client.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clients_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
}
