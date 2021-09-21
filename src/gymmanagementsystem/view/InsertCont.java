
package gymmanagementsystem.view;

import gymmanagementsystem.CallBack;
import gymmanagementsystem.control.Clients_Control;
import gymmanagementsystem.control.Insert_Control;
import gymmanagementsystem.model.Client;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableListBase;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;


public class InsertCont {
    @FXML
    TextField name,phone,emergency,type,sessions;
    @FXML
    Button  inserts;
    CallBack cl;
    public void insert(Event e) throws SQLException, IOException{
        Client c = new Client();
        c.setName(name.getText());
        c.setPhone(phone.getText());
        c.setEmergency(emergency.getText());
        c.setType(type.getText());
        c.setSessions(Integer.parseInt(sessions.getText()));
        Insert_Control ic = new Insert_Control();
        if(name.getText()!=""&&phone.getText()!=""&&emergency.getText()!=""&&type.getText()!=""){
            c = ic.ins(c);
        }
        
        cl.refresh(c);
        name.setText("");
        phone.setText("");
        emergency.setText("");
        type.setText("");
        sessions.setText("");
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
